/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Payment;
import com.vasslatam.sakila.services.domain.Rental;
import com.vasslatam.sakila.services.domain.Staff;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class PaymentRepository {
    @Inject
    private EntityManager em;
    
    /*
    public void create(Payment payment){
        Payment p = new Payment();
        p.setCustomer(payment.getCustomer());
        p.setStaff(payment.getStaff());
        p.setRental(payment.getRental());
        p.setAmount(payment.getAmount());
        p.setPaymentdate(LocalDateTime.now());
    }
    */
    
    public void create(Payment payment, Staff staff, Rental lastRental, Customer customer){
        payment.setStaff(staff);
        payment.setRental(lastRental);
        payment.setCustomer(customer);
        payment.setPaymentdate(LocalDateTime.now());
        payment.setLastUpdate(LocalDateTime.now());
        em.persist(payment);
    }
}
