/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author USERVASSPERU
 */
@Entity
@Table(name = "inventory")
public class Inventory implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "inventory_id")
    private int inventoryid;
    
    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film filmid;
     
    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store storeid;
    
    @Column(name = "last_update")
    private LocalDateTime LastUpdate;

    public int getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(int inventoryid) {
        this.inventoryid = inventoryid;
    }

    public Film getFilmid() {
        return filmid;
    }

    public void setFilmid(Film filmid) {
        this.filmid = filmid;
    }

    public Store getStoreid() {
        return storeid;
    }

    public void setStoreid(Store storeid) {
        this.storeid = storeid;
    }

    public LocalDateTime getLastUpdate() {
        return LastUpdate;
    }

    public void setLastUpdate(LocalDateTime LastUpdate) {
        this.LastUpdate = LastUpdate;
    }
    
    
}
