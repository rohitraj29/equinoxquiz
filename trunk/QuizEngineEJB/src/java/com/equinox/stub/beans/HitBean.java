/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.stub.beans;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Questions;
import com.equinox.ejb.entity.Test;
import com.equinox.ejb.entity.Users;

/**
 *
 * @author rohit
 */
public class HitBean implements java.io.Serializable{
    private Users userid;
    private Questions qid;
    private Test testid;
    private int response;
    private LoginSession session;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public LoginSession getSession() {
        return session;
    }

    public void setSession(LoginSession session) {
        this.session = session;
    }
    public Questions getQid() {
        return qid;
    }

    public void setQid(Questions qid) {
        this.qid = qid;
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
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
