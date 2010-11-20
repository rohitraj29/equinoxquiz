/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface DataBaseResetRemote {

    void resetDataBase();
    
}
