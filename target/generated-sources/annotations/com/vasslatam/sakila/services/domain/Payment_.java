package com.vasslatam.sakila.services.domain;

import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Rental;
import com.vasslatam.sakila.services.domain.Staff;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.6.v20200131-rNA", date="2020-05-04T11:43:35")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, BigDecimal> amount;
    public static volatile SingularAttribute<Payment, LocalDateTime> paymentdate;
    public static volatile SingularAttribute<Payment, LocalDateTime> LastUpdate;
    public static volatile SingularAttribute<Payment, Integer> paymentid;
    public static volatile SingularAttribute<Payment, Staff> staff;
    public static volatile SingularAttribute<Payment, Customer> customer;
    public static volatile SingularAttribute<Payment, Rental> rental;

}