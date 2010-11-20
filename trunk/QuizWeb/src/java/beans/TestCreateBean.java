/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Test;
import com.equinox.ejb.session.TestEntryRemote;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */

public class TestCreateBean {
    @EJB
    private TestEntryRemote testEntryBean;
private String tdetail;
private int tduration;
private int noques;
private int oncorrect;
private int onwrong;


    public int getNoques() {
        return noques;
    }

    public void setNoques(int noques) {
        this.noques = noques;
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

    public String getTdetail() {
        return tdetail;
    }

    public void setTdetail(String tdetail) {
        this.tdetail = tdetail;
    }

    public int getTduration() {
        return tduration;
    }

    public void setTduration(int tduration) {
        this.tduration = tduration;
    }

    /** Creates a new instance of TestCreateBean */
    public TestCreateBean() {
    }
    public String persist()
    {
        Test test=new Test();
        test.setDurationMin(tduration);
        test.setNoOfQues(noques);
        test.setTestname(tdetail);
        test.setOnCorrect(oncorrect);
        test.setOnWrong(onwrong);
       
        
        if(this.testEntryBean.create(test))
        {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Test Added Successfully","Test Added Successfully");
            FacesContext.getCurrentInstance().addMessage(null, msg); 
        return null;
        }
        else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to add test at this point of time","Unable to add test at this point of time");
            FacesContext.getCurrentInstance().addMessage(null, msg); return null;}
    }

}
