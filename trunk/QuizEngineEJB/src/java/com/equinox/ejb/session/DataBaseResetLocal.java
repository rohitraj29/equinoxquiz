/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface DataBaseResetLocal {

    void resetDataBase();
    
}
