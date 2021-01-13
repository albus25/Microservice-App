package com.mycompany.usermp.entity;

import com.mycompany.usermp.entity.Tblcity;
import com.mycompany.usermp.entity.Tblstudent;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-03T17:27:14")
@StaticMetamodel(Tbluser.class)
public class Tbluser_ { 

    public static volatile SingularAttribute<Tbluser, String> image;
    public static volatile CollectionAttribute<Tbluser, Tblstudent> tblstudentCollection;
    public static volatile SingularAttribute<Tbluser, String> password;
    public static volatile SingularAttribute<Tbluser, String> address;
    public static volatile SingularAttribute<Tbluser, Date> createdDate;
    public static volatile SingularAttribute<Tbluser, Tblcity> cityID;
    public static volatile SingularAttribute<Tbluser, Integer> userID;
    public static volatile SingularAttribute<Tbluser, String> email;
    public static volatile SingularAttribute<Tbluser, String> username;
    public static volatile SingularAttribute<Tbluser, String> contactNo;
    public static volatile SingularAttribute<Tbluser, Integer> status;

}