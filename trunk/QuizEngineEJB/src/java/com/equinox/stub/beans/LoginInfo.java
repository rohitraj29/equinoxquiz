/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.stub.beans;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Users;
import java.io.Serializable;

/**
 *
 * @author rohit
 */
public class LoginInfo implements Serializable{
private Users user;
private LoginSession session;

    public LoginSession getSession() {
        return session;
    }

    public void setSession(LoginSession session) {
        this.session = session;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

}
