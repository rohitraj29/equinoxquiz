/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Hits;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class HitsFacade implements HitsFacadeLocal, HitsFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Hits hits) {
        em.persist(hits);
    }

    public void edit(Hits hits) {
        em.merge(hits);
    }

    public void remove(Hits hits) {
        em.remove(em.merge(hits));
    }

    public Hits find(Object id) {
        return em.find(com.equinox.ejb.entity.Hits.class, id);
    }

    public List<Hits> findAll() {
        return em.createQuery("select object(o) from Hits as o").getResultList();
    }

}
