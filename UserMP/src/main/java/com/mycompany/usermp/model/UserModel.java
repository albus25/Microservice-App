/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermp.model;

import com.mycompany.usermp.entity.Tbluser;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author root
 */
@Named
@ApplicationScoped
public class UserModel {
    EntityManager em;
    Collection<Tbluser> users;
    
    public UserModel() {
        em = Persistence.createEntityManagerFactory("UserPU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Object[]> getUsers(Collection<Integer> ids) {
        String allIds = convertIntCollectionToString(ids);
        return em.createNativeQuery("select * from tbluser u where u.userID IN ("+allIds+")").getResultList();
    }
    
    private String convertIntCollectionToString(Collection<Integer> ids)
    {
        String intString="";
        for(Integer i : ids)
        {
            intString += i.toString() +",";
        }
        return intString.substring(0, intString.length()-1);
    }    
}
