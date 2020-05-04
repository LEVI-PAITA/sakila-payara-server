/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Staff;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class StaffRepository {
    @Inject
    private EntityManager em;
    public List<Staff>findAll(){
        TypedQuery<Staff> query = em.createQuery("select s from Staff s", Staff.class);
        return query.getResultList();
    }
    
    public Staff findById(int StaffId){
        return em.find(Staff.class, StaffId);
    }
}
