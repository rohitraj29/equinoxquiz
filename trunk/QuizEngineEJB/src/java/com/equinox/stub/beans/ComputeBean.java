/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.stub.beans;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Test;
import com.equinox.ejb.entity.Users;

/**
 *
 * @author rohit
 */
public class ComputeBean implements NewInterface{
    private Test testid;
    private Users userid;
    private LoginSession session;

    public LoginSession getSession() {
        return session;
    }

    public void setSession(LoginSession session) {
        this.session = session;
    }
    public Test getTestid() {
        return testid;
    }

    public void setTestid(Test testid) {
        this.testid = testid;
    }

    public Users getUserid() {
        return userid;
    }

    public void setUserid(Users userid) {
        this.userid = userid;
    }
    

}
