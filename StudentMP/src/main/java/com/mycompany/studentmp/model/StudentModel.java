/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentmp.model;

import com.mycompany.studentmp.entity.Tblstudent;
import java.util.ArrayList;
import java.util.Collection;
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
public class StudentModel {
    EntityManager em;
    Collection<Integer> availableIds;
    
    public StudentModel() {
        em = Persistence.createEntityManagerFactory("StudentPU").createEntityManager();
    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public Collection<Integer> getAvailableIds() {
        availableIds = new ArrayList<Integer>();
        Collection<Tblstudent> tblstudents = em.createQuery("SELECT s FROM Tblstudent s").getResultList();
        for (Tblstudent tblstudent : tblstudents) {
            availableIds.add(tblstudent.getUserID().getUserID());
        }
        return availableIds;
    }

    public void setAvailableIds(Collection<Integer> availableIds) {
        this.availableIds = availableIds;
    }
    
}
