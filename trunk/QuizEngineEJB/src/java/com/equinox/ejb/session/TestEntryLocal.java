/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Test;
import com.equinox.stub.beans.TestBean;
import javax.ejb.Local;

/**
 *
 * @author rohit
 */
@Local
public interface TestEntryLocal {

    void registerTest(TestBean testbean);

    boolean create(Test test);
    
}
