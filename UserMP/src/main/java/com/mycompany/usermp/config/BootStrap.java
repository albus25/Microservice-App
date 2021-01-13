package com.mycompany.usermp.config;
import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import org.eclipse.microprofile.auth.LoginConfig;

@SuppressWarnings({"EmptyClass", "SuppressionAnnotation"})
@ApplicationPath("rest")
@LoginConfig(authMethod = "MP-JWT")
@DeclareRoles({"Admin", "College", "Student"})
public class BootStrap extends javax.ws.rs.core.Application {
}
