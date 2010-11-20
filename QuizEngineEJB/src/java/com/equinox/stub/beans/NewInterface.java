/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.stub.beans;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Test;
import com.equinox.ejb.entity.Users;
import java.io.Serializable;

/**
 *
 * @author rohit
 */
public interface NewInterface extends Serializable {

    LoginSession getSession();

    Test getTestid();

    Users getUserid();

    void setSession(LoginSession session);

    void setTestid(Test testid);

    void setUserid(Users userid);

}
