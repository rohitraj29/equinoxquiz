/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Results;
import com.equinox.stub.beans.ResultBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class FinalResultBean implements FinalResultRemote, FinalResultLocal {
    @PersistenceContext
    private EntityManager em;

    public void persistResult(ResultBean resultbean) {
        Results results=new Results();
        results.setUserid(resultbean.getUserid());
        results.setTestid(resultbean.getTestid());
        results.setLoginsession(resultbean.getSession());
        results.setScore(resultbean.getScore());
        em.persist(results);
    }

   
    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
