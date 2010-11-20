/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rohit
 */
@Local
public interface CreateUserLocal {

    LoginSession validateUser(String username, String password, String role);

    List<Users> findAll();

   
    
}
