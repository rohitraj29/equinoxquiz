/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rohit
 */
@Remote
public interface CreateUserRemote {

    public void createUser(com.equinox.stub.beans.UserBean user);

    LoginSession validateUser(String username, String password, String role);

    public com.equinox.ejb.entity.Users findByObject(com.equinox.ejb.entity.Users user);

    public com.equinox.ejb.entity.Users findByName(java.lang.String username);

    public void generateUsers(java.lang.String str1, java.lang.String str2);

   public List<Users> findAll();

    
    
}
