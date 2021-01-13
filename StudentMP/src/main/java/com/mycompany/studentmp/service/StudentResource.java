/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentmp.service;

import com.mycompany.studentmp.model.StudentModel;
import java.util.Collection;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("student")
@RequestScoped
public class StudentResource {
    @Inject StudentModel sm;
    
    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Integer> allStudents() {
        System.out.println("in students "+sm.getAvailableIds());
        return sm.getAvailableIds();
    }
}
