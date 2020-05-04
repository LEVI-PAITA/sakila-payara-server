package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Film;
import com.vasslatam.sakila.services.domain.Store;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Inventory.class)
public class Inventory_ { 

    public static volatile SingularAttribute<Inventory, LocalDateTime> LastUpdate;
    public static volatile SingularAttribute<Inventory, Film> filmid;
    public static volatile SingularAttribute<Inventory, Integer> inventoryid;
    public static volatile SingularAttribute<Inventory, Store> storeid;

}