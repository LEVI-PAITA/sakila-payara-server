package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Address;
import com.vasslatam.sakila.services.domain.Store;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> firstname;
    public static volatile SingularAttribute<Customer, LocalDateTime> LastUpdate;
    public static volatile SingularAttribute<Customer, Integer> customerid;
    public static volatile SingularAttribute<Customer, Integer> active;
    public static volatile SingularAttribute<Customer, LocalDateTime> createdate;
    public static volatile SingularAttribute<Customer, Store> storeid;
    public static volatile SingularAttribute<Customer, String> email;
    public static volatile SingularAttribute<Customer, String> lastname;
    public static volatile SingularAttribute<Customer, Address> addressid;

}