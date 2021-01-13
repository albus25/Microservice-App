package com.mycompany.usermp.entity;

import com.mycompany.usermp.entity.Tblcity;
import com.mycompany.usermp.entity.Tblcountry;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-03T17:27:14")
@StaticMetamodel(Tblstate.class)
public class Tblstate_ { 

    public static volatile SingularAttribute<Tblstate, String> stateName;
    public static volatile CollectionAttribute<Tblstate, Tblcity> tblcityCollection;
    public static volatile SingularAttribute<Tblstate, Integer> stateID;
    public static volatile SingularAttribute<Tblstate, Tblcountry> countryID;
    public static volatile SingularAttribute<Tblstate, Integer> status;

}