/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Users;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class UsersFacade implements UsersFacadeLocal, UsersFacadeRemote {
    @PersistenceContext
    private EntityManager em;

    public void create(Users users) {
        em.persist(users);
    }

    public void edit(Users users) {
        em.merge(users);
    }

    public void remove(Users users) {
        em.remove(em.merge(users));
    }

    public Users find(Object id) {
        return em.find(com.equinox.ejb.entity.Users.class, id);
    }

    public List<Users> findAll() {
        return em.createQuery("select object(o) from Users as o").getResultList();
    }

}
