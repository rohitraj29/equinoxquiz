/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import com.equinox.ejb.entity.Results;
import com.equinox.ejb.entity.Test;
import com.equinox.ejb.session.FinalResultRemote;
import com.equinox.ejb.session.ResultBeanRemote;
import com.equinox.ejb.session.TestFacadeRemote;
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

public class ViewResBean {
    @EJB
    private TestFacadeRemote testFacade;
    
    @EJB
    private ResultBeanRemote resultBeanBean;
    
    
    
    private List<SelectItem> testlist;
    private List<Results> reslist;
    private String testname;

    public List<Results> getReslist() {
        this.updateAction();
        return reslist;
    }

    public void setReslist(List<Results> reslist) {
        this.reslist = reslist;
    }

    public List<SelectItem> getTestlist() {
        List<Test> temp=this.testFacade.findAll();
        ArrayList<SelectItem> list=new ArrayList<SelectItem>();
        Iterator itr=temp.iterator();
        while(itr.hasNext())
        {
            Test test=(Test) itr.next();
            SelectItem sel=new SelectItem();
            sel.setLabel(test.getTestname());
            sel.setValue(test.getTestname());
            list.add(sel);
        }
        this.testlist=list;
        return testlist;
    }

    public void setTestlist(List<SelectItem> testlist) {
        this.testlist = testlist;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    /** Creates a new instance of ViewResBean */
    public ViewResBean() {
    }

    
    public void ChangeFired(ValueChangeEvent e)
    {
        HtmlComboBox cmb1=(HtmlComboBox) e.getComponent();
        this.testname=(String) cmb1.getValue();
        
    }
    public String updateAction()
    {
        try {
            Test temp = this.testFacade.findByName(testname);
            this.reslist = this.resultBeanBean.getResult(temp);
            return null;

        } catch (Exception exception) {exception.printStackTrace();
        return null;
        }

    }
}
