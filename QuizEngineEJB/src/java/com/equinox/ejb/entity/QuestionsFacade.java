/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rohit
 */
@Stateless
public class QuestionsFacade implements QuestionsFacadeLocal, QuestionsFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Questions questions) {
        em.persist(questions);
    }

    public void edit(Questions questions) {
        em.merge(questions);
    }

    public void remove(Questions questions) {
        em.remove(em.merge(questions));
    }

    public Questions find(Object id) {
        return em.find(com.equinox.ejb.entity.Questions.class, id);
    }

    public List<Questions> findAll() {
        return em.createQuery("select object(o) from Questions as o").getResultList();
    }

}
