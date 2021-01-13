package com.mycompany.studentmp.entity;

import com.mycompany.studentmp.entity.Tblstate;
import com.mycompany.studentmp.entity.Tbluser;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-03T17:27:14")
@StaticMetamodel(Tblcity.class)
public class Tblcity_ { 

    public static volatile SingularAttribute<Tblcity, String> cityName;
    public static volatile SingularAttribute<Tblcity, Tblstate> stateID;
    public static volatile CollectionAttribute<Tblcity, Tbluser> tbluserCollection;
    public static volatile SingularAttribute<Tblcity, Integer> cityID;
    public static volatile SingularAttribute<Tblcity, Integer> status;

}