/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Country;
import com.vasslatam.sakila.services.repositories.CountryRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
@Transactional
public class CountryServices {
    @Inject
    private CountryRepository countryRepository;
    
    public List<Country> findAll(){
        return countryRepository.findAll();
    }
    
    public void create(Country country){
        countryRepository.create(country);
    }
    
    public Country findByid(int countryId){
        return countryRepository.findByid(countryId);
    }
    
    public void update(int countryId, Country country){
        countryRepository.update(countryId, country);
    }
    
    public void delete(int countryId){
        countryRepository.delete(countryId);
    }
}
