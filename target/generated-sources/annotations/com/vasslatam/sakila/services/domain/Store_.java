package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Address;
import com.vasslatam.sakila.services.domain.Staff;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Store.class)
public class Store_ { 

    public static volatile SingularAttribute<Store, Staff> managerStaff;
    public static volatile SingularAttribute<Store, LocalDateTime> LastUpdate;
    public static volatile SingularAttribute<Store, Integer> storeid;
    public static volatile SingularAttribute<Store, Address> addressid;

}