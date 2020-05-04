/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Country;
import java.time.LocalDateTime;
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
public class CountryRepository {
    @Inject
    private EntityManager em;
    
    public List<Country> findAll(){
        TypedQuery<Country> query = em.createQuery("select c from Country c", Country.class);
        return query.getResultList();
    }
   
   public void create(Country country){
       Country c = new Country();
       c.setCountry(country.getCountry());
       c.setLastUpdate(LocalDateTime.now());
       em.persist(c);
   }
   
   public Country findByid(int countryId){
       return em.find(Country.class, countryId);
   }
   
   public void update(int countryId, Country country){
       Country c = findByid(countryId);
       c.setCountry(country.getCountry());
       c.setLastUpdate(LocalDateTime.now());
       em.merge(c);
   }
   
   public void delete(int countryId){
       em.remove(findByid(countryId));
   }
}
