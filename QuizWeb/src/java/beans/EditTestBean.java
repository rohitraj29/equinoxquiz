/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Test;
import com.equinox.ejb.session.TestFacadeRemote;
import ejb.EjbAdapter;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

/**
 *
 * @author root
 */

public class EditTestBean {
private TestFacadeRemote  testFacadeRemote;
private Test currentTest;
private Long testid;
private String testname;
private int testduration;
private int noOfQues;
private int oncorrect;
private int onwrong;

    public Test getCurrentTest() {
        return currentTest;
    }

    public void setCurrentTest(Test currentTest) {
        this.currentTest = currentTest;
    }

    public int getNoOfQues() {
        return noOfQues;
    }

    public void setNoOfQues(int noOfQues) {
        this.noOfQues = noOfQues;
    }

    public int getOncorrect() {
        return oncorrect;
    }

    public void setOncorrect(int oncorrect) {
        this.oncorrect = oncorrect;
    }

    public int getOnwrong() {
        return onwrong;
    }

    public void setOnwrong(int onwrong) {
        this.onwrong = onwrong;
    }

    public int getTestduration() {
        return testduration;
    }

    public void setTestduration(int testduration) {
        this.testduration = testduration;
    }

    public Long getTestid() {
        return testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }
        
        
    /** Creates a new instance of EditTestBean */
    public EditTestBean() {
        this.testFacadeRemote=EjbAdapter.lookupTestFacade();
        
                
    }
    
    public void selectAction(ActionEvent ae)
    {
        HtmlAjaxCommandButton cmd=(HtmlAjaxCommandButton)ae.getComponent();
        this.testid=(Long) cmd.getData();
        this.currentTest=testFacadeRemote.find(testid);
        this.noOfQues=currentTest.getNoOfQues();
        this.oncorrect=currentTest.getOnCorrect();
        this.onwrong=currentTest.getOnWrong();
        this.testduration=currentTest.getDurationMin();
        this.testname=currentTest.getTestname();
    }
public String saveAction()
    {
        try {
            this.currentTest.setDurationMin(testduration);
            this.currentTest.setNoOfQues(noOfQues);
            this.currentTest.setTestname(testname);
            this.currentTest.setOnCorrect(oncorrect);
            this.currentTest.setOnWrong(onwrong);
            this.testFacadeRemote.edit(currentTest);
            
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,"Succesfully Saved the Test","Succesfully Saved the Test");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            return null;
        } catch (Exception e) {
            FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error Saving The Test","Error Saving the Test");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            e.printStackTrace();
            return null;
        }
    }

}
