/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.stub.beans.ResultBean;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface FinalResultRemote {

    void persistResult(ResultBean resultbean);
    
}
