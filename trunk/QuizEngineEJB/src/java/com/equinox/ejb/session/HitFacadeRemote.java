/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Hits;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface HitFacadeRemote {

    List<Hits> getHits(Long userid);

    void spoof(Long userid);

    public void Party(java.lang.Long userid);
    
    
}
