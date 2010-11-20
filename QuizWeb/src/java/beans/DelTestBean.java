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

public class DelTestBean {
private Test currenttest;
private Long testid;
private TestFacadeRemote testFacadeRemote;
    public Test getCurrenttest() {
        return currenttest;
    }

    public void setCurrenttest(Test currenttest) {
        this.currenttest = currenttest;
    }

    public Long getTestid() {
        return testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }
    /** Creates a new instance of DelTestBean */
    public DelTestBean() {
    }
    
public void actionPerformed(ActionEvent ae)
{
    try {
        HtmlAjaxCommandButton cmd = (HtmlAjaxCommandButton) ae.getComponent();
        this.testid = (Long) cmd.getData();
        this.testFacadeRemote = EjbAdapter.lookupTestFacade();
        this.currenttest = testFacadeRemote.find(testid);
        testFacadeRemote.remove(currenttest);
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Successfully Deleted the Test", "Successfully Deleted the Test");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception e) {
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "ERROR Deleting the test","ERROR Deleting the test");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        e.printStackTrace();
    }
            
}

}
