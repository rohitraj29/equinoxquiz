/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Hits;
import com.equinox.ejb.entity.Users;
import com.equinox.ejb.session.CreateUserRemote;
import com.equinox.ejb.session.HitFacadeRemote;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import org.richfaces.component.html.HtmlComboBox;

/**
 *
 * @author root
 */

public class CrackBean {
    @EJB
    private HitFacadeRemote hitFacadeBean;
    @EJB
    private CreateUserRemote createUserBean;

    private List<Hits> hitlist;
    private String userid;
    private List<SelectItem> userlist;

    public List<Hits> getHitlist() {
        return hitlist;
    }

    public void setHitlist(List<Hits> hitlist) {
        this.hitlist = hitlist;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public List<SelectItem> getUserlist() {
        updatenow();
        return userlist;
    }

    public void setUserlist(List<SelectItem> userlist) {
        this.userlist = userlist;
    }
    
    public void userChanged(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox)e.getComponent();
        this.userid=(String) cmb1.getValue();
    }
    /** Creates a new instance of CrackBean */
    public CrackBean() {
        
    }
public String updateAction()
{
    try {
        Users user = this.createUserBean.findByName(userid);

        updatenow();
        this.hitlist = this.hitFacadeBean.getHits(user.getUserid());
        return null;

    } catch (Exception exception) {exception.printStackTrace();
    return null;
    }

}
public String spoofAction()
{
    try {
        this.hitFacadeBean.spoof(this.createUserBean.findByName(userid).getUserid());
        updatenow();
        String str=updateAction();
        return null;

    } catch (Exception exception) {exception.printStackTrace();
    return null;
    }

}
public String PartyAction()
{
    try {
        this.hitFacadeBean.Party(this.createUserBean.findByName(userid).getUserid());
        updatenow();
        String str=updateAction();
        return null;

    } catch (Exception exception) {exception.printStackTrace();
    return null;
}
}

    private void updatenow() {
        
        List<Users> list = this.createUserBean.findAll();
        ArrayList<SelectItem> item = new ArrayList<SelectItem>();
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            Users user = (Users) itr.next();
            SelectItem s1 = new SelectItem();
            s1.setValue(user.getUsername());
            s1.setLabel(user.getUsername());
            item.add(s1);
        }
        this.userlist = item;
    }
    

}
