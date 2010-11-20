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
@Table(name = "HITS")
@NamedQueries({@NamedQuery(name = "Hits.findByHitid", query = "SELECT h FROM Hits h WHERE h.hitid = :hitid"), @NamedQuery(name = "Hits.findByResponse", query = "SELECT h FROM Hits h WHERE h.response = :response"), @NamedQuery(name = "Hits.findByConfstate", query = "SELECT h FROM Hits h WHERE h.confstate = :confstate")})
public class Hits implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "HITID", nullable = false)
    private Long hitid;
    @Column(name = "RESPONSE")
    private Integer response;
    @Column(name = "CONFSTATE")
    private Integer confstate;
    @JoinColumn(name = "QUESTID", referencedColumnName = "QID")
    @ManyToOne
    private Questions questid;
    @JoinColumn(name = "TESTID", referencedColumnName = "TESTID")
    @ManyToOne
    private Test testid;
    @JoinColumn(name = "UID", referencedColumnName = "USERID")
    @ManyToOne
    private Users uid;
    @JoinColumn(name="SESSIONID",referencedColumnName="ID")
    @ManyToOne
    private LoginSession sessionid;
    @Column(name="SCORE")
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public LoginSession getSessionid() {
        return sessionid;
    }

    public void setSessionid(LoginSession sessionid) {
        this.sessionid = sessionid;
    }
    public Hits() {
    }

    public Hits(Long hitid) {
        this.hitid = hitid;
    }

    public Long getHitid() {
        return hitid;
    }

    public void setHitid(Long hitid) {
        this.hitid = hitid;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public Integer getConfstate() {
        return confstate;
    }
    public void setConfstate(Integer confstate) {
        this.confstate = confstate;
    }
    public Questions getQuestid() {
        return questid;
    }
    public void setQuestid(Questions questid) {
        this.questid = questid;
    }
    public Test getTestid() {
        return testid;
    }
    public void setTestid(Test testid) {
        this.testid = testid;
    }
    public Users getUid() {
        return uid;
    }
    public void setUid(Users uid) {
        this.uid = uid;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hitid != null ? hitid.hashCode() : 0);
        return hash;
    }
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hits)) {
            return false;
        }
        Hits other = (Hits) object;
        if ((this.hitid == null && other.hitid != null) || (this.hitid != null && !this.hitid.equals(other.hitid))) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return "hit for "+this.questid+" response "+this.response+" by User id "+this.uid;
    }

}
