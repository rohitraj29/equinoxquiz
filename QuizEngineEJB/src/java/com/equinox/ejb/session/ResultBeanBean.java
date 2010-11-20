/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Results;
import com.equinox.ejb.entity.Test;
import com.equinox.ejb.entity.Users;
import com.equinox.stub.beans.ResultBean;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rohit
 */
@Stateless
public class ResultBeanBean implements ResultBeanRemote, ResultBeanLocal {
    @PersistenceContext
    private EntityManager em;
    private ResultBean result;

    public Vector computeResult(ResultBean result) {
        this.result=result;
    Query q1=em.createQuery("SELECT Object(o) FROM Hits o WHERE o.sessionid=:sessionid AND o.uid=:uid AND o.testid=:testid");    
    
    q1.setParameter("sessionid", result.getSession());
    q1.setParameter("uid",result.getUserid());
    q1.setParameter("testid", result.getTestid());
    List l1=q1.getResultList();
    Iterator itr=l1.iterator();
    Vector v1= new Vector();
    while(itr.hasNext())
    {
        v1.add(itr.next());
    }
    return(v1);
        
    }

    public List<Results> getResult(Test test) {
        Query q1=em.createQuery("SELECT Object(o) FROM Results o WHERE o.testid=:testid ORDER BY o.score");
        q1.setParameter("testid",test);
        return(q1.getResultList());
        
    }
    
   
    

    
    
 
}
