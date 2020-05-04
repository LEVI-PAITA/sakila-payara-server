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
@Table(name = "rental")
public class Rental implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "rental_id")
    private int rantalid;
    
    @Column(name = "rental_date")
    private LocalDateTime rentaldate;
    
    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventoryid;
    
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customerid;
    
    @Column(name = "return_date")
    private LocalDateTime return_date;
    
    @ManyToOne
    @JoinColumn(name = "staff_id")
    private Staff staffid;
    
    @Column(name = "last_update")
    private LocalDateTime lastupdate;

    public int getRantalid() {
        return rantalid;
    }

    public void setRantalid(int rantalid) {
        this.rantalid = rantalid;
    }

    public LocalDateTime getRentaldate() {
        return rentaldate;
    }

    public void setRentaldate(LocalDateTime rentaldate) {
        this.rentaldate = rentaldate;
    }

    public Inventory getInventoryid() {
        return inventoryid;
    }

    public void setInventoryid(Inventory inventoryid) {
        this.inventoryid = inventoryid;
    }

    public Customer getCustomerid() {
        return customerid;
    }

    public void setCustomerid(Customer customerid) {
        this.customerid = customerid;
    }

    public LocalDateTime getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }

    public Staff getStaffid() {
        return staffid;
    }

    public void setStaffid(Staff staffid) {
        this.staffid = staffid;
    }

    public LocalDateTime getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(LocalDateTime lastupdate) {
        this.lastupdate = lastupdate;
    }
    
    
}
