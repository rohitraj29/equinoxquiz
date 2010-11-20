/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.equinox.ejb.session;

import com.equinox.ejb.entity.LoginSession;
import com.equinox.ejb.entity.Users;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author rohit
 */
@Stateless
public class CreateUserBean implements CreateUserRemote, CreateUserLocal {

    @PersistenceContext
    private EntityManager em;

    public void createUser(com.equinox.stub.beans.UserBean user) {
        try {
            if (this.validateUsername(user.getUsername())) {
                Users temp = new Users();
                temp.setUsername(user.getUsername());
                temp.setRoleplayed(user.getRoleplayed());
                temp.setPassword(user.getPassword());
                temp.setReqadmin(false);
                em.persist(temp);
            } else {
                throw (new Exception());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public LoginSession validateUser(String username, String password, String role) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM Users o WHERE o.username = :username");
            q1.setParameter("username", username);
            Users temp = (Users) q1.getSingleResult();
            if (temp.getPassword().equals(password) && temp.getRoleplayed().equals(role)) {
               temp.setReqadmin(true);
               em.merge(temp);
               
               
                LoginSession l1;
                l1=new LoginSession();
                    l1.setDatelogin(new Date());
                l1.setUid(temp);
                em.persist(l1);
                
                /*try{
                    l1= (LoginSession)q1.getSingleResult();
                    if(l1.getDatelogin().equals(new Date()))
                    {
                        return l1;
                    }
                }catch(javax.persistence.NoResultException e)
                {
                    e.printStackTrace();
                    l1=new LoginSession();
                    l1.setDatelogin(new Date());
                l1.setUid(temp);
                em.persist(l1);
                }*/           
                
                 return l1;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    
    private boolean validateUsername(String username) {
        try {
            Query q1 = em.createQuery("SELECT Object(o) FROM Users o WHERE o.username = :username");
            q1.setParameter("username", username);
            Users temp = (Users) q1.getSingleResult();
            if (temp != null) {
                return false;
            }
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    public Users findByObject(Users user)
    {
       return em.find(Users.class, user);
    }
    public Users findByName(String username)
    {
        Query q1=em.createQuery("SELECT Object(o) FROM Users o WHERE o.username=:username");
        q1.setParameter("username",username);
        return((Users)q1.getSingleResult());
        
    }
    
    public void generateUsers(String str1,String str2)
    {
        int a1=Integer.parseInt(str1);
        int a2=Integer.parseInt(str2);
        for(int i=a1;i<=a2;i++)
        {
            Users user=new Users();
            user.setUsername("0"+(new Integer(i).toString()));
            user.setPassword("12345*");
            user.setRoleplayed("User");
            user.setReqadmin(false);
             em.persist(user);
            
        }
    }

    public List<Users> findAll() {
        Query q1=em.createQuery("SELECT Object(o) FROM Users o");
        return q1.getResultList();
        
    }
    
}

 
    

