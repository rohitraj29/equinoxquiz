/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Hits;
import com.equinox.ejb.entity.Users;
import com.equinox.stub.beans.HitBean;
import java.util.Iterator;
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
public class HitFacadeBean implements HitFacadeRemote, HitFacadeLocal {
    
  
    @PersistenceContext
    private EntityManager em;
    

    public List<Hits> getHits(Long userid) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM Hits o  where o.uid=:uid");
            q1.setParameter("uid", em.find(Users.class, userid));
            return q1.getResultList();
            
        } catch (Exception exception) {exception.printStackTrace();
        return null;
        }
        

        
    }

    public void spoof(Long userid) {
        List<Hits> l1=this.getHits(userid);
        Iterator itr=l1.iterator();
        while(itr.hasNext())
        {
            Hits hit=(Hits) itr.next();
            HitBean bean=new HitBean();
            bean.setQid(hit.getQuestid());
            bean.setResponse(1);
            bean.setScore(bean.getQid().getOptionCorrect().equals(bean.getResponse())?3:-1);
            bean.setSession(hit.getSessionid());
            bean.setTestid(hit.getTestid());
            bean.setUserid(hit.getUid());
            this.persistHit(bean);
            
            
            
        }
    }
    private Hits hit1;
    private  void persistHit(HitBean bean1) {
        try {
            Hits hit=new Hits();
            hit.setQuestid(bean1.getQid());
            hit.setResponse(bean1.getResponse());
            hit.setTestid(bean1.getTestid());
            hit.setSessionid(bean1.getSession());
            hit.setUid(bean1.getUserid());
            hit.setScore(bean1.getScore());
            this.hit1=hit;
            Query q1 = em.createQuery("SELECT Object(o) FROM Hits o WHERE o.questid=:questid AND o.sessionid=:sessionid");
            q1.setParameter("questid", bean1.getQid());
            q1.setParameter("sessionid", bean1.getSession());
            Hits temp = (Hits) q1.getSingleResult();
            if (temp == null) {
                em.persist(hit);
            } else {
                temp.setResponse(bean1.getResponse());
                temp.setScore(bean1.getScore());
                em.merge(temp);
            }
        } catch (Exception e) {
            em.persist(hit1);
            e.printStackTrace();
        }
    }

public void Party(Long userid) {
        List<Hits> l1=this.getHits(userid);
        Iterator itr=l1.iterator();
        while(itr.hasNext())
        {
            Hits hit=(Hits) itr.next();
            HitBean bean=new HitBean();
            bean.setQid(hit.getQuestid());
            bean.setResponse(hit.getQuestid().getOptionCorrect());
            bean.setScore(3);
            bean.setSession(hit.getSessionid());
            bean.setTestid(hit.getTestid());
            bean.setUserid(hit.getUid());
            this.persistHit(bean);
        }
    }
    
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
