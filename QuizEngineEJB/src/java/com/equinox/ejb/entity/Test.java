/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rohit
 */
@Entity
@Table(name = "TEST")
@NamedQueries({@NamedQuery(name = "Test.findByTestid", query = "SELECT t FROM Test t WHERE t.testid = :testid"), @NamedQuery(name = "Test.findByTestname", query = "SELECT t FROM Test t WHERE t.testname = :testname"), @NamedQuery(name = "Test.findByNoOfQues", query = "SELECT t FROM Test t WHERE t.noOfQues = :noOfQues"), @NamedQuery(name = "Test.findByDurationMin", query = "SELECT t FROM Test t WHERE t.durationMin = :durationMin"), @NamedQuery(name = "Test.findByOnCorrect", query = "SELECT t FROM Test t WHERE t.onCorrect = :onCorrect"), @NamedQuery(name = "Test.findByOnWrong", query = "SELECT t FROM Test t WHERE t.onWrong = :onWrong")})
public class Test implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "TESTID", nullable = false)
    private Long testid;
    @Column(name = "TESTNAME")
    private String testname;
    @Column(name = "NO_OF_QUES")
    private Integer noOfQues;
    @Column(name = "DURATION_MIN")
    private Integer durationMin;
    @Column(name = "ON_CORRECT")
    private Integer onCorrect;
    @Column(name = "ON_WRONG")
    private Integer onWrong;
    @OneToMany(mappedBy = "testid")
    private Collection<Hits> hitsCollection;
    @OneToMany(mappedBy = "testid")
    private Collection<Results> resultsCollection;
    @OneToMany(mappedBy = "testid")
    private Collection<Questions> questionsCollection;

    public Test() {
    }

    public Test(Long testid) {
        this.testid = testid;
    }

    public Long getTestid() {
        return testid;
    }

    public void setTestid(Long testid) {
        this.testid = testid;
    }

    public String getTestname() {
        return testname;
    }

    public void setTestname(String testname) {
        this.testname = testname;
    }

    public Integer getNoOfQues() {
        return noOfQues;
    }

    public void setNoOfQues(Integer noOfQues) {
        this.noOfQues = noOfQues;
    }

    public Integer getDurationMin() {
        return durationMin;
    }

    public void setDurationMin(Integer durationMin) {
        this.durationMin = durationMin;
    }

    public Integer getOnCorrect() {
        return onCorrect;
    }

    public void setOnCorrect(Integer onCorrect) {
        this.onCorrect = onCorrect;
    }

    public Integer getOnWrong() {
        return onWrong;
    }

    public void setOnWrong(Integer onWrong) {
        this.onWrong = onWrong;
    }

    public Collection<Hits> getHitsCollection() {
        return hitsCollection;
    }

    public void setHitsCollection(Collection<Hits> hitsCollection) {
        this.hitsCollection = hitsCollection;
    }

    public Collection<Results> getResultsCollection() {
        return resultsCollection;
    }

    public void setResultsCollection(Collection<Results> resultsCollection) {
        this.resultsCollection = resultsCollection;
    }

    public Collection<Questions> getQuestionsCollection() {
        return questionsCollection;
    }

    public void setQuestionsCollection(Collection<Questions> questionsCollection) {
        this.questionsCollection = questionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testid != null ? testid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.testid == null && other.testid != null) || (this.testid != null && !this.testid.equals(other.testid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.testname;
    }

}
