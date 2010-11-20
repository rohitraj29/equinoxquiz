/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.stub.beans.LoginInfo;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rohit
 */
@Remote
public interface GetTestStatusRemote {

    List<LoginInfo> getLoggedInStatus();
    
}
