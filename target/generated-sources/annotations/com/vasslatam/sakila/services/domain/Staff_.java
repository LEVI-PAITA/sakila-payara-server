package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Address;
import com.vasslatam.sakila.services.domain.Store;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Staff.class)
public class Staff_ { 

    public static volatile SingularAttribute<Staff, String> firstname;
    public static volatile SingularAttribute<Staff, String> password;
    public static volatile SingularAttribute<Staff, LocalDateTime> LastUpdate;
    public static volatile SingularAttribute<Staff, Boolean> active;
    public static volatile SingularAttribute<Staff, Store> store;
    public static volatile SingularAttribute<Staff, Integer> staffid;
    public static volatile SingularAttribute<Staff, byte[]> picture;
    public static volatile SingularAttribute<Staff, String> email;
    public static volatile SingularAttribute<Staff, String> lastname;
    public static volatile SingularAttribute<Staff, Address> addressid;
    public static volatile SingularAttribute<Staff, String> username;

}