/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.session.CreateUserRemote;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */

public class GenerateUser {
    @EJB
    private CreateUserRemote createUserBean;
    public String fromid;
    public String toid;
    public String persist()
   {   
       try {
           this.createUserBean.generateUsers(fromid, toid);
           FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,"Users Generated Successfully","Users Generated Successfully");
           FacesContext.getCurrentInstance().addMessage(null, msg);
           return null;

       } catch (Exception exception) {exception.printStackTrace();
       FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Cannot generate users at this time please try again later","Cannot generate users at this time please try again later");
           FacesContext.getCurrentInstance().addMessage(null, msg);
       return null;
       }

    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    /** Creates a new instance of GenerateUser */
    public GenerateUser() {
    }

}
