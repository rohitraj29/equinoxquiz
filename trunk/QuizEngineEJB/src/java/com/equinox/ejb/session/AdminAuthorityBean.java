/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Users;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rohit
 */
@Stateless
public class AdminAuthorityBean implements AdminAuthorityRemote, AdminAuthorityLocal {
    @PersistenceContext
    private EntityManager em;

    public boolean authorizeLogin(String username) {
    
    Users user=(Users)em.createNamedQuery("Users.findByUsername").setParameter("username",username).getSingleResult();    
    user.setReqadmin(false);
    return(true);
    }

    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
