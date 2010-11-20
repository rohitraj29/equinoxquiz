/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.session;

import com.equinox.ejb.entity.LoginSession;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface LoginSessionFacadeRemote {

    void create(LoginSession loginSession);

    void edit(LoginSession loginSession);

    void remove(LoginSession loginSession);

    LoginSession find(Object id);

    List<LoginSession> findAll();

}
