/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.stub.beans;

/**
 *
 * @author rohit
 */
public class TestBean  implements java.io.Serializable{

    private String testname;
    private int testdur;
    private int oncorrect;
    private int onwrong;
    private int no_of_ques;

    public int getNo_of_ques() {
        return no_of_ques;
    }

    public void setNo_of_ques(int no_of_ques) {
        this.no_of_ques = no_of_ques;
    }

    public int getOncorrect() {
        return oncorrect;
    }

    public void setOncorrect(int oncorrect) {
        this.oncorrect = oncorrect;
    }

    public int getOnwrong() {
        return onwrong;
    }

    public void setOnwrong(int onwrong) {
        this.onwrong = onwrong;
    }

    public int getTestdur() {
        return testdur;
    }

    public void setTestdur(int testdur) {
        this.testdur = testdur;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }
    
}
