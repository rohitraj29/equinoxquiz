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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author rohit
 */
@Entity
@Table(name = "QUESTIONS")
@NamedQueries({@NamedQuery(name = "Questions.findByQid", query = "SELECT q FROM Questions q WHERE q.qid = :qid"), @NamedQuery(name = "Questions.findByQuestion", query = "SELECT q FROM Questions q WHERE q.question = :question"), @NamedQuery(name = "Questions.findByOption1", query = "SELECT q FROM Questions q WHERE q.option1 = :option1"), @NamedQuery(name = "Questions.findByOption2", query = "SELECT q FROM Questions q WHERE q.option2 = :option2"), @NamedQuery(name = "Questions.findByOption3", query = "SELECT q FROM Questions q WHERE q.option3 = :option3"), @NamedQuery(name = "Questions.findByOption4", query = "SELECT q FROM Questions q WHERE q.option4 = :option4"), @NamedQuery(name = "Questions.findByOptionCorrect", query = "SELECT q FROM Questions q WHERE q.optionCorrect = :optionCorrect")})
public class Questions implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "QID", nullable = false)
    private Long qid;
    @Column(name = "QUESTION")
    private String question;
    @Column(name = "OPTION1")
    private String option1;
    @Column(name = "OPTION2")
    private String option2;
    @Column(name = "OPTION3")
    private String option3;
    @Column(name = "OPTION4")
    private String option4;
    @Column(name = "OPTION_CORRECT")
    private Integer optionCorrect;
    @OneToMany(mappedBy = "questid")
    private Collection<Hits> hitsCollection;
    @JoinColumn(name = "TESTID", referencedColumnName = "TESTID")
    @ManyToOne
    private Test testid;

    public Questions() {
    }

    public Questions(Long qid) {
        this.qid = qid;
    }

    public Long getQid() {
        return qid;
    }

    public void setQid(Long qid) {
        this.qid = qid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public Integer getOptionCorrect() {
        return optionCorrect;
    }

    public void setOptionCorrect(Integer optionCorrect) {
        this.optionCorrect = optionCorrect;
    }

    public Collection<Hits> getHitsCollection() {
        return hitsCollection;
    }

    public void setHitsCollection(Collection<Hits> hitsCollection) {
        this.hitsCollection = hitsCollection;
    }

    public Test getTestid() {
        return testid;
    }

    public void setTestid(Test testid) {
        this.testid = testid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (qid != null ? qid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questions)) {
            return false;
        }
        Questions other = (Questions) object;
        if ((this.qid == null && other.qid != null) || (this.qid != null && !this.qid.equals(other.qid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.question;
    }

}
