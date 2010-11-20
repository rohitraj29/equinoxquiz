package beans;


import com.equinox.ejb.entity.Hits;
import com.equinox.ejb.entity.Questions;
import com.equinox.ejb.session.HitEntryLocal;
import com.equinox.ejb.session.HitEntryRemote;
import com.equinox.ejb.session.QuestionEntryRemote;
import com.equinox.stub.beans.HitBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.ejb.EJB;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;


public class TestBean implements Serializable{
    
    @EJB
    private HitEntryRemote hitEntryBean;
    @EJB
    private QuestionEntryRemote questionEntryBean;
   
    private List<QuestionWrap> qlist;
    private LoginBean loginbean;
    private PrepareTestBean preparetestbean;
    private Integer response;
    private int durationmili;
    private int remaining;
    private QuestionWrap currentvar;
    private int qno;
    private List<SelectItem> optionlist;
    private List<Hits> attempted;
    public List<SelectItem> getOptionlist() {
        return optionlist;
    }

    public void setOptionlist(List<SelectItem> optionlist) {
        this.optionlist = optionlist;
    }
    

    
    public int getQno() {
        return qno;
    }

    public void setQno(int qno) {
        if(qno>=0&&qno<qlist.size())
        {this.qno = qno;}
        
        
    }
    
    public QuestionWrap getCurrentvar() {
        if(currentvar==null)
        {
            initializeList();
        }
       
        return currentvar;
    }

    public void setCurrentvar(QuestionWrap current) {
        this.currentvar = current;
    }
    

    public int getRemaining() {
        
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

    public int getDurationmili() {
        this.durationmili=this.getPreparetestbean().getTest().getDurationMin()*60000;
        return durationmili;
    }

    public void setDurationmili(int durationmili) {
        this.durationmili = durationmili;
    }

    public Integer getResponse() {
        if(response!=null)
        return response;
        else
            return(new Integer(1));
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public LoginBean getLoginbean() {
        FacesContext fc=FacesContext.getCurrentInstance();
        this.loginbean=(LoginBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{LoginBean}", LoginBean.class).getValue(fc.getELContext());
        return loginbean;
    }

    public void setLoginbean(LoginBean loginbean) {
        this.loginbean = loginbean;
    }

    public PrepareTestBean getPreparetestbean() {
        
              FacesContext fc=FacesContext.getCurrentInstance();
              this.preparetestbean=(PrepareTestBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{PrepareTestBean}", PrepareTestBean.class).getValue(fc.getELContext());
        return preparetestbean;
    }

    public void setPreparetestbean(PrepareTestBean prreparetestbean) {
        this.preparetestbean = prreparetestbean;
    }
    
    public TestBean()
    {
       
         FacesContext fc=FacesContext.getCurrentInstance();
        this.loginbean=(LoginBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{LoginBean}", LoginBean.class).getValue(fc.getELContext());
        this.preparetestbean=(PrepareTestBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{PrepareTestBean}", PrepareTestBean.class).getValue(fc.getELContext());
        
        Vector<SelectItem> v1=new Vector<SelectItem>();
        v1.add(new SelectItem(1, "1"));
        v1.add(new SelectItem(2, "2"));
        v1.add(new SelectItem(3, "3"));
        v1.add(new SelectItem(4, "4"));
        this.optionlist=v1;
        this.qno=0;
    }

    public List<QuestionWrap> getQlist() {
        
        return qlist;
    }

    public void setQlist(List<QuestionWrap> qlist) {
        this.qlist = qlist;
    }

    private Vector<Long> getAttempted()
    {
        this.attempted=this.hitEntryBean.findBySession(this.loginbean.getLoginSession().getUid(), this.loginbean.getLoginSession());
        Vector v3=new Vector();
        if(this.attempted!=null)
        {
        Iterator itr=this.attempted.iterator();
        while(itr.hasNext())
        {
            Hits temp=(Hits)itr.next();
            v3.add(temp.getQuestid().getQid());
        }
        }
        return v3;
    }
    private void initializeList() {
        List temp=this.questionEntryBean.findByTestObject(this.preparetestbean.getTest());
        //Vector<Long> v4 = new Vector<Long();
        Vector<Long> v4 = new Vector<Long>();
        Iterator itr=temp.iterator();
        int i=0;
        ArrayList temp2= new ArrayList();
        
        
        while(itr.hasNext())
        {   QuestionWrap ques=new QuestionWrap();
            Questions fr=(Questions)itr.next();
            if(v4.contains(fr.getQid()))
            {ques.setBackground("#c7ebea");}
            ques.setQuestio(fr);
            ques.setIndex(i);
            ques.setQnumber(++i);
            temp2.add(ques);
        }
        this.qlist=temp2;
        this.currentvar=qlist.get(qno);
       
    }
    public void increment(ActionEvent e)
    {
        int temp=this.remaining;
        temp++;
        this.remaining=temp;
    }
    
    
    public String submitaction()
    {
        try {
            int ind = qlist.indexOf(this.currentvar);
            QuestionWrap ques = this.currentvar;
            ques.setBackground("#c7ebea");
            qlist.set(ind, ques);
            
            HitBean hit = new HitBean();
            hit.setQid(ques.getQuestio());
            hit.setResponse(this.getResponse());
            hit.setUserid(loginbean.getLoginSession().getUid());
            hit.setSession(loginbean.getLoginSession());
            hit.setTestid(this.preparetestbean.getTest());
            if ((this.response).equals(ques.getQuestio().getOptionCorrect())) {
                hit.setScore(ques.getQuestio().getTestid().getOnCorrect());
            } else {
                hit.setScore(ques.getQuestio().getTestid().getOnWrong());
            }
            this.hitEntryBean.persistHit(hit);
            
            return null;
        } catch (Exception e) {
            return "login";
        }
    }
    
    public String prevaction()
    {
        try {
            this.setQno(qno - 1);
            this.currentvar = qlist.get(qno);
            return null;
        } catch (Exception e) {
            return "login";
        }
    }
    
    public String nextaction()
    {
        try {
            this.setQno(qno + 1);
            this.currentvar = qlist.get(qno);
            return null;
        } catch (Exception e) {
            return "login";
        }
                
    }
    
    public void valueChanged(ValueChangeEvent e)
    {
    UIInput select=(UIInput)e.getComponent();    
    this.response = (Integer)select.getValue();
    }
    
    public String finishAction()
    {
        return("result");
    }
}