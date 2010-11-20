/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import com.equinox.ejb.entity.QuestionsFacadeRemote;
import com.equinox.ejb.session.QuestionEntryRemote;
import com.equinox.ejb.session.TestFacadeRemote;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author root
 */
public class EjbAdapter {

    public static TestFacadeRemote lookupTestFacade() {
        try {
            Context c = new InitialContext();
            return (TestFacadeRemote) c.lookup("java:comp/env/TestFacade");
        } catch (NamingException ne) {
            
            throw new RuntimeException(ne);
        }
    }

    public static QuestionEntryRemote lookupQuestionEntryBean() {
        try {
            Context c = new InitialContext();
            return (QuestionEntryRemote) c.lookup("java:comp/env/QuestionEntryBean");
        } catch (NamingException ne) {
            
            throw new RuntimeException(ne);
        }
    }

    public static QuestionsFacadeRemote lookupQuestionsFacade() {
        try {
            Context c = new InitialContext();
            return (QuestionsFacadeRemote) c.lookup("java:comp/env/QuestionsFacade");
        } catch (NamingException ne) {
            
            throw new RuntimeException(ne);
        }
    }
    
    

}
