package com.mycompany.usermp.entity;

import com.mycompany.usermp.entity.Tblstate;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-01-03T17:27:14")
@StaticMetamodel(Tblcountry.class)
public class Tblcountry_ { 

    public static volatile CollectionAttribute<Tblcountry, Tblstate> tblstateCollection;
    public static volatile SingularAttribute<Tblcountry, String> countryName;
    public static volatile SingularAttribute<Tblcountry, Integer> countryID;
    public static volatile SingularAttribute<Tblcountry, Integer> status;

}