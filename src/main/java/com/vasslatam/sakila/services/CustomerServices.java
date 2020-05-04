/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.repositories.CustomerRepository;
import java.math.BigDecimal;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class CustomerServices {
    @Inject
    private CustomerRepository customerRepository;
    
    public BigDecimal getcustomer(int rental) {
        return customerRepository.getcustomer(rental);
    }
    
    public Customer findById(int customerId){
        return customerRepository.findById(customerId);
    }
    
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }
}
