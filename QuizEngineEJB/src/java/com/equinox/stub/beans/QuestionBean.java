/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.stub.beans;

import com.equinox.ejb.entity.Test;

/**
 *
 * @author rohit
 */
public class QuestionBean  implements java.io.Serializable{

    private Long qid;
    private Test testid;
    private String qdetail;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private int correct;

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public String getOpt1() {
        return opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getQdetail() {
        return qdetail;
    }

    public void setQdetail(String qdetail) {
        this.qdetail = qdetail;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public Test getTestid() {
        return testid;
    }

    public void setTestid(Test testid) {
        this.testid = testid;
    }
    
}
