/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.equinox.ejb.entity.Test;

import com.equinox.ejb.session.QuestionEntryRemote;

import com.equinox.ejb.session.TestFacadeRemote;
import com.equinox.stub.beans.QuestionBean;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

/**
 *
 * @author root
 */
public class AdminQuesBean {

    @EJB
    private QuestionEntryRemote questionEntryBean;
    @EJB
    private TestFacadeRemote testFacade;
    private List<SelectItem> itemlist;
    private Test current;
    private QuestionBean ques;
    private Long testid;

    public Long getTestid() {
        return testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }

    /** Creates a new instance of AdminQuesBean */
    public AdminQuesBean() {
        this.ques = new QuestionBean();
    }

    public String item() {
        return null;
    }

    public Test getCurrent() {
        return current;
    }

    public void setCurrent(Test current) {
        this.current = current;
    }

    public QuestionBean getQues() {
        if (ques == null) {
            return new QuestionBean();
        } else {
            return ques;
        }
    }

    public void setQues(QuestionBean ques) {
        this.ques = ques;
    }

    public List<SelectItem> getItemlist() {
        current = new Test();
        List<Test> temp = this.testFacade.findAll();
        Iterator itr = temp.iterator();
        ArrayList list = new ArrayList();
        while (itr.hasNext()) {
            Test test = (Test) itr.next();
            list.add(new SelectItem(test.getTestid(), test.toString()));
        }
        this.itemlist = list;
        return itemlist;
    }

    public void setItemlist(List<SelectItem> itemlist) {
        this.itemlist = itemlist;
    }

    public void eventListener(ValueChangeEvent e) {
    UIInput ui=(UIInput) e.getComponent();
    this.testid=(Long)ui.getValue();


    }

    public String persist() {
        try {
            ques.setTestid(this.testFacade.find(testid));
            this.questionEntryBean.registerQuestions(ques);
            this.ques = new QuestionBean();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Question Added Successfully", "Question Added Successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg);            
            return null;
        } catch (Exception e) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),e.getLocalizedMessage());
            FacesContext.getCurrentInstance().addMessage(null, msg); 
            return null;
        }
    }
}
