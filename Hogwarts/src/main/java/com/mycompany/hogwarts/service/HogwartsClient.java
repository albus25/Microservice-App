/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hogwarts.service;

import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author root
 */
@RegisterRestClient(configKey = "hogwartsClient",baseUri = "http://localhost:8080/UserMP/rest")
@ApplicationScoped
@Path("/user")
public interface HogwartsClient {
    
    @GET
    @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Object[]> getUsers();

    default String generateJWTToken() {
        Config config = ConfigProvider.getConfig();
        String token = "Bearer " + GenerateToken.generateJWT();
        System.out.println("Hogwarts Token :- " + token);
        return token;
    }
}