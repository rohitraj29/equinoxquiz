/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.session.CreateUserRemote;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author root
 */

public class LoginBean {
    @EJB
    private CreateUserRemote createUserBean;
    private String username;
    private String password;
    private String role;
    private LoginSession loginSession;
    private boolean valid;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public LoginSession getLoginSession() {
        
        return loginSession;
    }

    public void setLoginSession(LoginSession loginSession) {
        this.loginSession = loginSession;
    }

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
    

    /** Creates a new instance of LoginBean */
    public LoginBean() {
    }
   
    public String userlogin()
    {
        try {
            this.role = "User";
            LoginSession loginsession = createUserBean.validateUser(username, password, role);
            if (loginsession != null) {
                this.loginSession = loginsession;
                this.setValid(true);
                return ("testpage");
            } else {
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to Authenticate User Please Contact your Administrator", "Unable to Authenticate User Please Contact your Administrator");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Unable to Authenticate User Please Contact your Administrator", "Unable to Authenticate User Please Contact your Administrator");
                FacesContext.getCurrentInstance().addMessage(null, message);
                return null;
        }
    }
    
    public String adminlogin()
    {
        this.role="Administrator";
        LoginSession loginsession=createUserBean.validateUser(username, password, role);
        if(loginsession!=null)
      {
            this.loginSession=loginsession;
            this.setValid(true);
          return("admin");
      }
      else return "loginfailure";
    }

}
