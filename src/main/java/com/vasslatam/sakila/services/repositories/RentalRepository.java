/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Inventory;
import com.vasslatam.sakila.services.domain.Rental;
import com.vasslatam.sakila.services.domain.Staff;
import java.time.LocalDateTime;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author USERVASSPERU
 */

@ApplicationScoped
public class RentalRepository {
    @Inject
    private EntityManager em;
    
    public void create(Rental rental, Customer customer, Inventory inventory, Staff staffl){
        rental.setCustomerid(customer);
        rental.setInventoryid(inventory);
        rental.setStaffid(staffl);
        rental.setReturn_date(LocalDateTime.now());
        rental.setLastupdate(LocalDateTime.now());
        em.persist(rental);
    }
    
    public Rental findById(int rentalId){
        return em.find(Rental.class, rentalId);
    }
    
    public Rental lastInsert(){
        Query query = em.createNativeQuery("SELECT MAX(rental_id) FROM Rental");
        int result = (int) query.getSingleResult();
        return findById(result);
    }
    
     public void createrental(Rental rental) {
        rental.setLastupdate(LocalDateTime.now());
        em.persist(rental);
    }
    
}
