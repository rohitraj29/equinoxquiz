/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.session.CreateUserRemote;
import com.equinox.stub.beans.UserBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */

public class CreateUserBean {
    @EJB
    private CreateUserRemote createUserBean;
    private String username;
    private String password;
    private String role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String persist()
    {
        try {
            UserBean usr = new UserBean();
            usr.setUsername(username);
            usr.setPassword(password);
            usr.setRoleplayed(role);
            createUserBean.createUser(usr);
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "User Has Been Successfully Created", "User Has Been Successfully Created");
            FacesContext.getCurrentInstance().addMessage(null, msg);
            nullify();
            return null;
        } catch (Exception e) {
           FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "User Registration Not successful try again", "User Registration Not successful try again");
            FacesContext.getCurrentInstance().addMessage(null, msg); 
            nullify();
            return null;
        }
    }
private void nullify()
{
    this.username=null;
    this.password=null;
    this.role=null;
}
    /** Creates a new instance of CreateUserBean */
    public CreateUserBean() {
        
    }

}
