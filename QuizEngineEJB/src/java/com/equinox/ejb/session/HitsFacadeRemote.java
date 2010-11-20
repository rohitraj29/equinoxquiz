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
public interface HitsFacadeRemote {

    void create(Hits hits);

    void edit(Hits hits);

    void remove(Hits hits);

    Hits find(Object id);

    List<Hits> findAll();

}
