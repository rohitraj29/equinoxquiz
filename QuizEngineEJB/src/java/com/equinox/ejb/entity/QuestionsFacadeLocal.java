/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.equinox.ejb.entity;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author rohit
 */
@Local
public interface QuestionsFacadeLocal {

    void create(Questions questions);

    void edit(Questions questions);

    void remove(Questions questions);

    Questions find(Object id);

    List<Questions> findAll();

}
