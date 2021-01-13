/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author root
 */
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "hogwartsjndi",
        callerQuery = "select password from tbluser where userName = ?",
        groupsQuery = "select groupName from tbluser u,tblgroup g,tblusergroup ug where ug.userID = u.userID and ug.groupID = g.groupID and u.userName = ?",
        hashAlgorithm = Pbkdf2PasswordHash.class,
        priority = 30)
@ApplicationScoped
public class Project {
    
}
