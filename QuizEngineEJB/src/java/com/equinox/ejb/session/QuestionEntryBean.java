/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Questions;
import com.equinox.ejb.entity.Test;
import com.equinox.stub.beans.TestBean;
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
public class QuestionEntryBean implements QuestionEntryRemote, QuestionEntryLocal {
    @PersistenceContext
    EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
    public void registerQuestions(com.equinox.stub.beans.QuestionBean ques)
    {
        try{
            Questions q1= new Questions();
            q1.setQuestion(ques.getQdetail());
            q1.setTestid(ques.getTestid());
            q1.setOptionCorrect(ques.getCorrect());
            q1.setOption1(ques.getOpt1());
            q1.setOption2(ques.getOpt2());
            q1.setOption3(ques.getOpt3());
            q1.setOption4(ques.getOpt4());
            em.persist(q1);
        }catch(Exception e){e.printStackTrace();}
    }
        public List<Questions> findByTest(TestBean test)
        {
            Query q1= em.createNamedQuery("Test.findByTestName");
            q1.setParameter("testname",test.getTestname());
            Test temp=(Test)q1.getSingleResult();
            q1=em.createQuery("SELECT Object(o) FROM Questions o WHERE testid=:testid");
            q1.setParameter("testid", temp);
            return(q1.getResultList());
            
        }

    public List findByTestObject(Test test) {
          Query q1=em.createQuery("SELECT Object(o) FROM Questions o WHERE o.testid=:testid");
          q1.setParameter("testid",test );
          return(q1.getResultList());
    }

    

    
    
    
    
    
    
}
