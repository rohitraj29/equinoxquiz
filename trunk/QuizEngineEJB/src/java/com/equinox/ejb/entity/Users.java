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
@Table(name = "USERS")
@NamedQueries({@NamedQuery(name = "Users.findByUserid", query = "SELECT u FROM Users u WHERE u.userid = :userid"), @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"), @NamedQuery(name = "Users.findByRoleplayed", query = "SELECT u FROM Users u WHERE u.roleplayed = :roleplayed")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "USERID", nullable = false)
    private Long userid;
    @Column(name="USERNAME")
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLEPLAYED")
    private String roleplayed;
    @OneToMany(mappedBy = "uid")
    private Collection<Hits> hitsCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Results> resultsCollection;
    @Column(name="REQADMIN")
    private boolean reqadmin;

    public boolean isReqadmin() {
        return reqadmin;
    }

    public void setReqadmin(boolean reqadmin) {
        this.reqadmin = reqadmin;
    }
    public Users() {
    }

    public Users(Long userid) {
        this.userid = userid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleplayed() {
        return roleplayed;
    }

    public void setRoleplayed(String roleplayed) {
        this.roleplayed = roleplayed;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.username;
    }

}
