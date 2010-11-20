/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Test;
import com.equinox.stub.beans.TestBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rohit
 */
@Stateless
public class TestEntryBean implements TestEntryRemote, TestEntryLocal {
    @PersistenceContext
    private EntityManager em;

    public void registerTest(TestBean testbean) {
    try{
    Test t1= new Test();
    t1.setTestname(testbean.getTestname());
    t1.setNoOfQues(testbean.getNo_of_ques());
    t1.setOnCorrect(testbean.getOncorrect());
    t1.setOnWrong(testbean.getOnwrong());
    t1.setDurationMin(testbean.getTestdur());
    em.persist(t1);
    }catch(Exception e){e.printStackTrace();}
    }

    public boolean create(Test test) {
        try {
            em.persist(test);
            return true;

        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }

    }

    
    
    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
