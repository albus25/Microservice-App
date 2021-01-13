/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.usermp.service;

import com.mycompany.usermp.model.UserModel;
import java.util.Collection;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("user")
@RequestScoped
public class UserResource {
    @Inject UserModel userModel;
    @Inject @RestClient StudentClient studentClient;
    
    @Inject JsonWebToken token;

    public UserResource() {
        System.out.println("In UserResource");
    }
    
    
    @GET
    @RolesAllowed({"Admin"})
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getUsers() {
        System.out.println("com.mycompany.usermp.service.UserResource.getUsers()");
        System.out.println("Raw Token in User :- " + token.getRawToken());
        RawToken.setRtoken(token.getRawToken());
        System.out.println("Entered in User Resource");
        Collection<Integer> allIds = studentClient.allStudents();
        return userModel.getUsers(allIds);
    }
}
