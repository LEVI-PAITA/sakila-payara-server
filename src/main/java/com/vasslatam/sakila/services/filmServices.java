/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Actor;
import com.vasslatam.sakila.services.domain.Category;
import com.vasslatam.sakila.services.domain.Film;
import com.vasslatam.sakila.services.domain.Film_actor;
import com.vasslatam.sakila.services.repositories.FilmRepository;
import com.vasslatam.sakila.services.type.Rating;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 *
 * @author USERVASSPERU
 */
@ApplicationScoped
public class filmServices {
    @Inject
    private FilmRepository filmrepository;
    
    
    public List<Film>findAll(){
        return filmrepository.findAll();
    }
    
    public List<Film>findByActor(Actor actor){
        return filmrepository.findByActor(actor);
    }
    
    public List<Film>FindByActores(List<Actor> actores){
        return filmrepository.findByActores(actores);
    }
    
    public List<Film>findByCategorias(List<Category> categorias){
        return filmrepository.findBycategorias(categorias);
    }
    
    public List<Film_actor>findByFilm(String actor,String descripcion,String title, Rating rating){
        return filmrepository.findByFilm(actor,descripcion, title, rating);
    }
    
}
