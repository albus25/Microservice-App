package com.mycompany.studentmp.entity;

import com.mycompany.studentmp.entity.Tbluser;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-03T17:27:14")
@StaticMetamodel(Tblstudent.class)
public class Tblstudent_ { 

    public static volatile SingularAttribute<Tblstudent, Integer> studentID;
    public static volatile SingularAttribute<Tblstudent, String> gender;
    public static volatile SingularAttribute<Tblstudent, String> studentName;
    public static volatile SingularAttribute<Tblstudent, String> bio;
    public static volatile SingularAttribute<Tblstudent, Date> dateOfBirth;
    public static volatile SingularAttribute<Tblstudent, Integer> isPremium;
    public static volatile SingularAttribute<Tblstudent, Tbluser> userID;

}