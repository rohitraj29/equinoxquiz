/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.Hits;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface HitFacadeLocal {

    List<Hits> getHits(Long userid);

    void spoof(Long userid);
    
}
