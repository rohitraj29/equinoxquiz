/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinox.ejb.session;

import com.equinox.ejb.entity.Hits;
import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Users;
import com.equinox.stub.beans.HitBean;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rohit
 */
@Stateless
public class HitEntryBean implements HitEntryRemote, HitEntryLocal {

    @PersistenceContext
    EntityManager em;
    private Hits hit;
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
    public void persistHit(HitBean bean1) {
        try {
            this.hit=new Hits();
            this.hit.setQuestid(bean1.getQid());
            this.hit.setResponse(bean1.getResponse());
            this.hit.setTestid(bean1.getTestid());
            this.hit.setSessionid(bean1.getSession());
            this.hit.setUid(bean1.getUserid());
            this.hit.setScore(bean1.getScore());
            Query q1 = em.createQuery("SELECT Object(o) FROM Hits o WHERE o.questid=:questid AND o.sessionid=:sessionid");
            q1.setParameter("questid", bean1.getQid());
            q1.setParameter("sessionid", bean1.getSession());
            Hits temp = (Hits) q1.getSingleResult();
            if (temp == null) {
                em.persist(this.hit);
            } else {
                temp.setResponse(bean1.getResponse());
                temp.setScore(bean1.getScore());
                em.merge(temp);
            }
        } catch (Exception e) {
            em.persist(hit);
            e.printStackTrace();
        }
    }

    public List<Hits> findBySession(Users u, LoginSession login) {
        Query q1 = em.createQuery("SELECT Object(o) FROM Hits o WHERE o.uid=:uid AND o.sessionid=:sessionid");
        q1.setParameter("uid", u);
        q1.setParameter("sessionid", login);
        List l1 = q1.getResultList();
        if (l1 == null) {
            l1 = new ArrayList<Hits>();
        }
        return l1;
    }
}
