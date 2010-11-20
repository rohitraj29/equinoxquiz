/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Questions;
import com.equinox.ejb.entity.QuestionsFacadeRemote;
import com.equinox.ejb.entity.Test;
import com.equinox.ejb.session.QuestionEntryRemote;
import com.equinox.ejb.session.TestFacadeRemote;
import ejb.EjbAdapter;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class ListQuesBean{
    
private TestFacadeRemote testFacade;
private QuestionsFacadeRemote questionsFacadeRemote;
private QuestionEntryRemote questionEntryRemote;
private List<SelectItem> testlist;
private Long testid;
private Test currentTest;
private List<Questions> queslist;

    public List<Questions> getQueslist() {
        try {
            this.queslist = this.questionEntryRemote.findByTestObject(currentTest);
            return queslist;
        } catch (Exception e) {
            return null;
        }
    }

    public void setQueslist(List<Questions> queslist) {
        this.queslist = queslist;
    }

    public Test getCurrentTest() {
        return currentTest;
    }

    public void setCurrentTest(Test currentTest) {
        this.currentTest = currentTest;
    }

    public Long getTestid() {
        return testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }

    public List<SelectItem> getTestlist() {
        return testlist;
    }

    public void setTestlist(List<SelectItem> testlist) {
        this.testlist = testlist;
    }

    
    public ListQuesBean() {
        this.testFacade=EjbAdapter.lookupTestFacade();
        this.questionsFacadeRemote = EjbAdapter.lookupQuestionsFacade();
         this.questionEntryRemote=EjbAdapter.lookupQuestionEntryBean();
        this.prepareTestList();
        
    }
    public String selectAction()
    {
        try {
            this.currentTest = this.testFacade.find(testid);
            
            this.queslist = this.questionEntryRemote.findByTestObject(currentTest);
            return null;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Please Select A test from the drop down box","Please Select A test from the drop down box");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return null;
        }
    }
    
    public void valueChanged(ValueChangeEvent vce)
    {
        HtmlComboBox cmb=(HtmlComboBox)vce.getComponent();
        Long id=(Long)cmb.getValue();
        this.testid=id;
     
    }
    
    private void prepareTestList()
    {
        List<Test> list=this.testFacade.findAll();
        Iterator itr=list.iterator();
        List<SelectItem> temp= new Vector<SelectItem>();
        while(itr.hasNext())
        {
            Test t=(Test)itr.next();
            temp.add(new SelectItem(t.getTestid(),t.getTestname()));
        }
        this.testlist=temp;
    }
    
    public void deleteQues(ActionEvent ae)
    {
        try {
            HtmlAjaxCommandButton cmd = (HtmlAjaxCommandButton) ae.getComponent();
            Long id = (Long) cmd.getData();
            
            this.questionsFacadeRemote.remove(this.questionsFacadeRemote.find(id));
             this.queslist=this.questionEntryRemote.findByTestObject(currentTest);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Succesfully deleted Question", "Succesfully deleted Question");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to delete Question","Unable to delete Question");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        }
        
    }

}
