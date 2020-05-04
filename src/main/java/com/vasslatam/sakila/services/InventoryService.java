/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Inventory;
import com.vasslatam.sakila.services.repositories.InventoryRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class InventoryService {
    @Inject
    private InventoryRepository inventoryRepository;

    public boolean inventoryInStock(int inventoryId) {
        return inventoryRepository.inventoryInStock(inventoryId);
    }
    
    public Inventory findById(int invetoryId){
        return inventoryRepository.findById(invetoryId);
    }
    
    public List<Inventory> findAll(){
        return inventoryRepository.findAll();
    }
}
