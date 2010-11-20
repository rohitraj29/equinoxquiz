/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.stub.beans;

/**
 *
 * @author rohit
 */

public class UserBean  implements java.io.Serializable{
    private String username;
    private String password;
    private String roleplayed;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String userid) {
        this.username = userid;
    }
    

}
