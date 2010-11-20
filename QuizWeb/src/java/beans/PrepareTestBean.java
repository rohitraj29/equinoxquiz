/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import com.equinox.ejb.entity.Test;

import com.equinox.ejb.entity.Users;
import com.equinox.ejb.session.TestFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

/**
 *
 * @author root
 */
public class PrepareTestBean {
   
    @EJB
    private TestFacadeRemote testFacade;
    
    private LoginBean loginfo;
    private Users user;
    private List<Test> testvector;
    private Test test;
    private Long testid;
    private List<SelectItem> itemList;
    
    public String checkTestExists()
    {
        if(this.test!=null||this.testid!=null)
            return "starttest";
        else{
            addErrorMessage("You Have Not Selected Any Tests Please Select a Test before Continuing");
            return null;}
    }
    public LoginBean getLoginfo() {
        return loginfo;
    }

    public void setLoginfo(LoginBean loginfo) {
        this.loginfo = loginfo;
    }

    public List<Test> getTestvector() {
        this.testvector=this.testFacade.findAll();
        
        return testvector;
    }

    public List<SelectItem> getItemList() {
        ArrayList list=new ArrayList();
        Iterator itr=this.getTestvector().iterator();
        while(itr.hasNext())
        {
            Test temp=(Test)itr.next();
            SelectItem sel=new SelectItem();
            sel.setValue(temp);
            sel.setLabel(temp.getTestname());
            list.add(sel);
        }
        return list;
    }

    public void setItemList(List<SelectItem> itemList) {
        this.itemList = itemList;
    }

    public void setTestvector(List<Test> testvector) {
        this.testvector = testvector;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    

    public Test getTest() {
        return test;
       
    }

    public void setTest(Test test) {
        this.test = test;
    }
    /** Creates a new instance of PrepareTestBean */
    public PrepareTestBean() {
        System.out.println("Constructor of class called");
        FacesContext fc=FacesContext.getCurrentInstance();
        Map map=fc.getExternalContext().getSessionMap();
        this.loginfo=(LoginBean)map.get("LoginBean");
        
   }
    
    
   
    
    public void selectaction(ActionEvent e)
    {
        try {
            HtmlAjaxCommandButton com = (HtmlAjaxCommandButton) e.getComponent();
            Long id = (Long) com.getData();
            this.testid = id;
            this.test = testFacade.find(id);
            addSuccessMessage("You Have Selected a Test now You can Proceed");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage("successInfo", facesMsg);
    }
   
}
