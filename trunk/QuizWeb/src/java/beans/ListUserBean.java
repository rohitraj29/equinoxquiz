/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Users;
import com.equinox.ejb.session.UsersFacadeRemote;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.ajax4jsf.component.html.HtmlAjaxCommandButton;

/**
 *
 * @author root
 */

public class ListUserBean {
    @EJB
    private UsersFacadeRemote usersFacade;
private List<Users> userlist;
    /** Creates a new instance of ListUserBean */
    public ListUserBean() {
        
        
    }

    public List<Users> getUserlist() {
        this.userlist=usersFacade.findAll();
        return userlist;
    }

    public void setUserlist(List<Users> userlist) {
        this.userlist = userlist;
        
    }
    
public void deleteAction(ActionEvent e){
    try {
        HtmlAjaxCommandButton cmd = (HtmlAjaxCommandButton) e.getComponent();
        Long id = (Long) cmd.getData();
        deleteUser(id);
        FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_INFO,"User has been Succesfully deleted","User has been Succesfully deleted");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    } catch (Exception ex) {
        FacesMessage msg= new FacesMessage(FacesMessage.SEVERITY_ERROR,"Unable to delete User cause::"+ex.getMessage(),"Unable to delete User cause::"+ex.getMessage());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}


private void deleteUser(Long id){
    usersFacade.remove(usersFacade.find(id));
}
}
