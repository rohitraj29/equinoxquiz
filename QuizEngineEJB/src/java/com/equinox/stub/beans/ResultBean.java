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
public class ResultBean implements java.io.Serializable{
private Users userid;
private Test testid;
private int score;
private LoginSession session;

    public LoginSession getSession() {
        return session;
    }

    public void setSession(LoginSession session) {
        this.session = session;
    }
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
    public ResultBean()
    {
        
    }
}
