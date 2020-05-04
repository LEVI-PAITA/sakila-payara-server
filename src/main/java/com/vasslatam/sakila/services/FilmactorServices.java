/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Film_actor;
import com.vasslatam.sakila.services.repositories.FilmactorRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class FilmactorServices {
    @Inject
    private FilmactorRepository filmactorRepository;
    
    public List<Film_actor> findAll(){
        return filmactorRepository.findAll();
    }
}
