/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Test;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rohit
 */
@Local
public interface QuestionEntryLocal {

     List findByTestObject(Test test);
    
}
