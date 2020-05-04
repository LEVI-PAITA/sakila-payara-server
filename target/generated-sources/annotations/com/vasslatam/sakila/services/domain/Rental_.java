package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Inventory;
import com.vasslatam.sakila.services.domain.Staff;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Rental.class)
public class Rental_ { 

    public static volatile SingularAttribute<Rental, Inventory> inventoryid;
    public static volatile SingularAttribute<Rental, Customer> customerid;
    public static volatile SingularAttribute<Rental, LocalDateTime> lastupdate;
    public static volatile SingularAttribute<Rental, Integer> rantalid;
    public static volatile SingularAttribute<Rental, LocalDateTime> rentaldate;
    public static volatile SingularAttribute<Rental, Staff> staffid;
    public static volatile SingularAttribute<Rental, LocalDateTime> return_date;

}