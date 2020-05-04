/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Inventory;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
@Transactional
public class InventoryRepository {
    @Inject
    private EntityManager em;

    public Boolean inventoryInStock(int inventoryId) {
        Query query = em.createNativeQuery("SELECT inventory_in_stock(?)")
                .setParameter(1, inventoryId);
        Boolean result = (Boolean) query.getSingleResult();
        return result;
    }
    
    public Inventory findById(int inventoryId){
        return em.find(Inventory.class, inventoryId);
    }

    public List<Inventory> findAll(){
        TypedQuery<Inventory> query = em.createQuery("select i from Inventory i", Inventory.class);
        return query.getResultList();
    }
    

}
