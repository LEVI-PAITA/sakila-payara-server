/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.City;
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
public class CityRepository {
    @Inject
    private EntityManager em;
    
    public List<City>findAll(){
        TypedQuery<City> query = em.createQuery("select c from City c", City.class);
        return query.getResultList();
    }
}
