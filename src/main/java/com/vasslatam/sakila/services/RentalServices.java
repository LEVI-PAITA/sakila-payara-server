/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Inventory;
import com.vasslatam.sakila.services.domain.Rental;
import com.vasslatam.sakila.services.domain.Staff;
import com.vasslatam.sakila.services.repositories.RentalRepository;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
@Transactional
public class RentalServices {
    @Inject
    private RentalRepository rentalrepository;
    
    public void create(Rental rental, Customer customer, Inventory inventory, Staff staffl){
        rentalrepository.create(rental,customer,inventory,staffl);
    }
    
    public Rental lastInsert(){
        return rentalrepository.lastInsert();
    }
    public Rental findById(int rentalId){
        return rentalrepository.findById(rentalId);
    }
    public void createrental(Rental rental){
        rentalrepository.createrental(rental);
    }
}
