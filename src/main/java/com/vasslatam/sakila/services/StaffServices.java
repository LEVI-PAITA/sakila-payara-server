/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Staff;
import com.vasslatam.sakila.services.repositories.StaffRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class StaffServices {
    @Inject
    private StaffRepository staffRepository;
    
    public List<Staff>findAll(){
        return staffRepository.findAll();
    }
    
    public Staff findById(int staffId){
        return staffRepository.findById(staffId);
    }
}
