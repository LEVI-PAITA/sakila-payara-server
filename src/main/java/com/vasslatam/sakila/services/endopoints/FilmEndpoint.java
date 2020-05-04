/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.endopoints;

import com.vasslatam.sakila.services.ActorServices;
import com.vasslatam.sakila.services.CategoryServices;
import com.vasslatam.sakila.services.domain.Actor;
import com.vasslatam.sakila.services.domain.Category;
import com.vasslatam.sakila.services.domain.Film;
import com.vasslatam.sakila.services.domain.Film_actor;
import com.vasslatam.sakila.services.filmServices;
import com.vasslatam.sakila.services.type.Rating;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author USERVASSPERU
 */
@Path("film")
@Produces(MediaType.APPLICATION_JSON)
public class FilmEndpoint {
    @Inject
    private filmServices filservices;
    
    @Inject
    private ActorServices actorService;
    
    @Inject
    private CategoryServices categoryservice;
    
    @GET
    public Response FindAll(){
        List<Film> filmies = filservices.findAll();
        return Response.ok(filmies).build();
    }
    
    @GET
    @Path("by-actor")
    public Response findByActor(@QueryParam("actor") String actorName) {
        List<Actor> actors = actorService.findByName(actorName);
        if (actors.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Actor actor = actors.get(0);
        List<Film> films = filservices.findByActor(actor);
        return Response.ok(films).build();
    }
    
    @GET
    @Path("by-actores")
    public Response findByActores(@QueryParam("actores") String actorName) {
        List<Actor> actors = actorService.findByName(actorName);
        if (actors.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Film> films = filservices.FindByActores(actors);
        return Response.ok(films).build();
    }
    
    @GET
    @Path("by-categorias")
    public Response findByCategorias(@QueryParam("categorias") String categorianame){
        List<Category> categories = categoryservice.findByCategoria(categorianame);
        if(categories.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        List<Film> films = filservices.findByCategorias(categories);
        return Response.ok(films).build();
    }
    
    
    @GET
    @Path("by-films")
    public Response findByFilm(@QueryParam("actor") String actorName, @QueryParam("description")String descripcion,@QueryParam("title") String title,@QueryParam("rating") Rating rating){
        /*List<Actor> actors = actorService.findByName(actorName);
        if (actors.isEmpty()){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        Actor actor = actors.get(0);
        */
        List<Film_actor> films = filservices.findByFilm(actorName, descripcion, title, rating);
        return Response.ok(films).build();
    }
    
}
