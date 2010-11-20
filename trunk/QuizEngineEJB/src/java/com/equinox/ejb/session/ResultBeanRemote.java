/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Results;
import com.equinox.ejb.entity.Test;
import com.equinox.stub.beans.ResultBean;
import java.util.List;
import java.util.Vector;
import javax.ejb.Remote;

/**
 *
 * @author rohit
 */
@Remote
public interface ResultBeanRemote {

    Vector computeResult(ResultBean result);

    List<Results> getResult(Test test);
    
}
