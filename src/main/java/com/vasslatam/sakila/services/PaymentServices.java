/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Payment;
import com.vasslatam.sakila.services.domain.Rental;
import com.vasslatam.sakila.services.domain.Staff;
import com.vasslatam.sakila.services.repositories.PaymentRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author Levi
 */
@ApplicationScoped
@Transactional
public class PaymentServices {
    @Inject
    private PaymentRepository paymentrepository;
    
    public void create(Payment payment, Staff staff, Rental lastRental, Customer customer){
        paymentrepository.create(payment, staff, lastRental, customer);
    }
    
}
