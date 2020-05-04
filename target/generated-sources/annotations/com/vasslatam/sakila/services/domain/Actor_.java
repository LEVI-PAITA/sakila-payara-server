package com.vasslatam.sakila.services.domain;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Actor.class)
public class Actor_ { 

    public static volatile SingularAttribute<Actor, String> firstname;
    public static volatile SingularAttribute<Actor, Integer> actorid;
    public static volatile SingularAttribute<Actor, LocalDateTime> lastupdate;
    public static volatile SingularAttribute<Actor, String> lastname;

}