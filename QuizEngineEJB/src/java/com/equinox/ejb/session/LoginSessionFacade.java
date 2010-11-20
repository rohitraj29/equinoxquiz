/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.LoginSession;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class LoginSessionFacade implements LoginSessionFacadeLocal, LoginSessionFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(LoginSession loginSession) {
        em.persist(loginSession);
    }

    public void edit(LoginSession loginSession) {
        em.merge(loginSession);
    }

    public void remove(LoginSession loginSession) {
        em.remove(em.merge(loginSession));
    }

    public LoginSession find(Object id) {
        return em.find(com.equinox.ejb.entity.LoginSession.class, id);
    }

    public List<LoginSession> findAll() {
        return em.createQuery("select object(o) from LoginSession as o").getResultList();
    }

}
