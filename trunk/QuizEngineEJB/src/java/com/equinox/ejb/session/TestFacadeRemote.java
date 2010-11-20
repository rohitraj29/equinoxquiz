/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Test;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface TestFacadeRemote {

    void create(Test test);

    void edit(Test test);

    void remove(Test test);

    Test find(Object id);

    List<Test> findAll();

    public com.equinox.ejb.entity.Test findByName(java.lang.String str);

}
