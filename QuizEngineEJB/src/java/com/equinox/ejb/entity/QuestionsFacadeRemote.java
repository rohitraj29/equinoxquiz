/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author rohit
 */
@Remote
public interface QuestionsFacadeRemote {

    void create(Questions questions);

    void edit(Questions questions);

    void remove(Questions questions);

    Questions find(Object id);

    List<Questions> findAll();

}
