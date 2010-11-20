/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Test;
import com.equinox.ejb.session.TestFacadeRemote;
import ejb.EjbAdapter;
import java.util.List;

/**
 *
 * @author root
 */

public class ListTestBean {

    private List<Test> testlist;
    private TestFacadeRemote testFacadeRemote;
    /** Creates a new instance of ListTestBean */
    public ListTestBean() {
        update();
        
        
    }
    private void update()
    {
        this.testFacadeRemote=EjbAdapter.lookupTestFacade();
        this.testlist=this.testFacadeRemote.findAll();
    }

    public List<Test> getTestlist() {
        update();
        return testlist;
    }

    public void setTestlist(List<Test> testlist) {
        this.testlist = testlist;
    }
    

}
