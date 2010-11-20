/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Hits;
import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Users;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rohit
 */
@Local
public interface HitEntryLocal {

    
    public void persistHit(com.equinox.stub.beans.HitBean bean1);
    public List<Hits> findBySession(Users uid, LoginSession loginSession);
}
