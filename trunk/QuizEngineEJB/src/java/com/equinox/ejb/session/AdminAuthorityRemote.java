/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import javax.ejb.Remote;

/**
 *
 * @author rohit
 */
@Remote
public interface AdminAuthorityRemote {

    boolean authorizeLogin(String username);
    
}
