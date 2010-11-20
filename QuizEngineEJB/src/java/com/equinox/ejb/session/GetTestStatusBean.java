/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author rohit
 */
@Stateless
public class GetTestStatusBean implements GetTestStatusRemote, GetTestStatusLocal {

    

    public List getLoggedInStatus() {
        return null;
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "EJB Methods > Add Business Method" or "Web Service > Add Operation")
 
}
