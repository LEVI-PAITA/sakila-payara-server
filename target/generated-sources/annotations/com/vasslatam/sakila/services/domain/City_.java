package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Country;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(City.class)
public class City_ { 

    public static volatile SingularAttribute<City, Country> country;
    public static volatile SingularAttribute<City, String> city;
    public static volatile SingularAttribute<City, LocalDateTime> LastUpdate;
    public static volatile SingularAttribute<City, Integer> cityid;

}