/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.repositories;

import com.vasslatam.sakila.services.domain.Film_actor;
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
public class FilmactorRepository {
    @Inject
    private EntityManager em;
    
    public List<Film_actor> findAll(){
        TypedQuery<Film_actor> query = em.createQuery("select f from Film_actor f", Film_actor.class);
        return query.getResultList();
    }
}
