/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Actor;
import com.vasslatam.sakila.services.repositories.ActorRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class ActorServices {
    @Inject
    private ActorRepository actorrepository;
    
    public List<Actor>findAll(){
        return actorrepository.findAll();
    }
    
    public List<Actor> findByName(String name) {
        return actorrepository.findByName(name);
    }
}
