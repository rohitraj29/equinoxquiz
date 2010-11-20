/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Hits;
import com.equinox.ejb.session.FinalResultRemote;
import com.equinox.ejb.session.ResultBeanRemote;
import com.equinox.stub.beans.ResultBean;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author root
 */

public class ResultBeanPrep  implements Serializable{
    @EJB
    private FinalResultRemote finalResultBean;
    @EJB
    private ResultBeanRemote resultBeanBean;

    private LoginBean loginbean1;
    private PrepareTestBean ptb1;
    private TestBean tb1;
    private int score;
    private List<Hits> result;

    public List getResult() {
        List l1=this.result;
        FacesContext fc=FacesContext.getCurrentInstance();
        HttpSession session=(HttpSession)fc.getExternalContext().getSession(false);
        session.invalidate();
        return l1;
        
    }

    public void setResult(List result) 
    {
        this.result = result;
    }

    public int getScore() 
    {
      if(score==0)  
      init();
      return score;  
    }
    

    public void setScore(int score) 
    {
        this.score = score;
    }

    public LoginBean getLoginbean1() 
    {
        FacesContext fc=FacesContext.getCurrentInstance();
        loginbean1=(LoginBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{LoginBean}", LoginBean.class).getValue(fc.getELContext());
        
        return loginbean1;
    }

    public void setLoginbean1(LoginBean loginbean1) {
        this.loginbean1 = loginbean1;
    }

    public PrepareTestBean getPtb1() {
        FacesContext fc=FacesContext.getCurrentInstance();
        ptb1=(PrepareTestBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{PrepareTestBean}", PrepareTestBean.class).getValue(fc.getELContext());
        return ptb1;
    }

    public void setPtb1(PrepareTestBean ptb1) {
        this.ptb1 = ptb1;
    }

    public TestBean getTb1() {
        FacesContext fc=FacesContext.getCurrentInstance();
        tb1=(TestBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{TestBean}", TestBean.class).getValue(fc.getELContext());
        return tb1;
    }

    public void setTb1(TestBean tb1) {
        this.tb1 = tb1;
    }
    
    public ResultBeanPrep() {
        FacesContext fc=FacesContext.getCurrentInstance();
        loginbean1=(LoginBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{LoginBean}", LoginBean.class).getValue(fc.getELContext());
        ptb1=(PrepareTestBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{PrepareTestBean}", PrepareTestBean.class).getValue(fc.getELContext());
        tb1=(TestBean)fc.getApplication().getExpressionFactory().createValueExpression(fc.getELContext(), "#{TestBean}", TestBean.class).getValue(fc.getELContext());
        
        
       this.score=0;
        }
    
    public void init()
    {
       try{ ResultBean bean1=new ResultBean();
        bean1.setUserid(this.getLoginbean1().getLoginSession().getUid());
        bean1.setSession(this.getLoginbean1().getLoginSession());
        bean1.setTestid(this.getPtb1().getTest());
       this.result=this.resultBeanBean.computeResult(bean1);
        Iterator itr=result.iterator();
        while(itr.hasNext())
        {   Hits hittemp=(Hits)itr.next();
            Integer inttemp=hittemp.getScore();
            this.score=this.score + inttemp.intValue();
        
        }
        bean1.setScore(this.score);
        this.finalResultBean.persistResult(bean1);
       
        
        
        
       }catch(Exception e)
       {
           System.out.println("INIT EXECUTED");
       }
    }

}
