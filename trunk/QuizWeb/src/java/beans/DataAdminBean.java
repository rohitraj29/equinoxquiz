/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.session.DataBaseResetRemote;
import javax.ejb.EJB;

/**
 *s
 * @author root
 */

public class DataAdminBean {
    @EJB
    private DataBaseResetRemote dataBaseResetBean;

    /** Creates a new instance of DataAdminBean */
    public DataAdminBean() {
        
    }
    public String resetDataBase()
    {
        this.dataBaseResetBean.resetDataBase();
        return null;
    }

}
