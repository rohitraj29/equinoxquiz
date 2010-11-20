/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinox.ejb.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author root
 */
@Stateless
public class DataBaseResetBean implements DataBaseResetRemote, DataBaseResetLocal {

    @PersistenceContext
    private EntityManager em;

    public void resetDataBase() {
        try {
            Query q1 = em.createQuery("DELETE FROM Results o");
            Query q3 = em.createQuery("DELETE FROM Hits o");
            Query q2 = em.createQuery("DELETE FROM LoginSession o");
            Query q4 = em.createQuery("DELETE FROM Users o");
            Query q5 = em.createQuery("DELETE FROM Test o");
            Query q6 = em.createQuery("DELETE FROM Questions o");
            q1.executeUpdate();
            q2.executeUpdate();
            q3.executeUpdate();
            q4.executeUpdate();
            q5.executeUpdate();
            q6.executeUpdate();

        } catch (Exception exception) {
            exception.printStackTrace();
        }



    }
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
}
