/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Test;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class TestFacade implements TestFacadeLocal, TestFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Test test) {
        em.persist(test);
    }

    public void edit(Test test) {
        em.merge(test);
    }

    public void remove(Test test) {
        em.remove(em.merge(test));
    }

    public Test find(Object id) {
        return em.find(com.equinox.ejb.entity.Test.class, id);
    }

    public List<Test> findAll() {
        return em.createQuery("select object(o) from Test as o").getResultList();
    }
    public Test findByName(String str){
        Query q1=em.createNamedQuery("Test.findByTestname");
        q1.setParameter("testname", str);
        return (Test) q1.getSingleResult();
    }

}
