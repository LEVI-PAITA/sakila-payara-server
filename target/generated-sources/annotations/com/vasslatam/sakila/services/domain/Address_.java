package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.City;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Address.class)
public class Address_ { 

    public static volatile SingularAttribute<Address, String> address;
    public static volatile SingularAttribute<Address, String> address2;
    public static volatile SingularAttribute<Address, City> city;
    public static volatile SingularAttribute<Address, String> phone;
    public static volatile SingularAttribute<Address, LocalDateTime> LastUpdate;
    public static volatile SingularAttribute<Address, String> postalcode;
    public static volatile SingularAttribute<Address, String> district;
    public static volatile SingularAttribute<Address, byte[]> location;
    public static volatile SingularAttribute<Address, Integer> addressid;

}