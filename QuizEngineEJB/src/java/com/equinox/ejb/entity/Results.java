/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author rohit
 */
@Entity
@Table(name = "RESULTS")
@NamedQueries({@NamedQuery(name = "Results.findByRid", query = "SELECT r FROM Results r WHERE r.rid = :rid"), @NamedQuery(name = "Results.findByScore", query = "SELECT r FROM Results r WHERE r.score = :score")})
public class Results implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "RID", nullable = false)
    private Long rid;
    @Column(name = "SCORE")
    private Integer score;
    @JoinColumn(name = "TESTID", referencedColumnName = "TESTID")
    @ManyToOne
    private Test testid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Users userid;
    @JoinColumn(name="LOGINSESSION",referencedColumnName="ID")
    @ManyToOne
    private LoginSession loginsession;

    public LoginSession getLoginsession() {
        return loginsession;
    }

    public void setLoginsession(LoginSession loginsession) {
        this.loginsession = loginsession;
    }
    public Results() {
    }

    public Results(Long rid) {
        this.rid = rid;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rid != null ? rid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Results)) {
            return false;
        }
        Results other = (Results) object;
        if ((this.rid == null && other.rid != null) || (this.rid != null && !this.rid.equals(other.rid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.equinox.ejb.entity.Results[rid=" + rid + "]";
    }

}
