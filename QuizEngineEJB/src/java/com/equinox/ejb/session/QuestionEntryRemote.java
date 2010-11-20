/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Questions;
import com.equinox.ejb.entity.Test;
import com.equinox.stub.beans.TestBean;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rohit
 */
@Remote
public interface QuestionEntryRemote {

    public void registerQuestions(com.equinox.stub.beans.QuestionBean ques);

    public List<Questions> findByTest(TestBean test);

    List findByTestObject(Test test);

    
    
}
