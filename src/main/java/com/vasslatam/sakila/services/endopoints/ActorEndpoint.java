/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.endopoints;

import com.vasslatam.sakila.services.ActorServices;
import com.vasslatam.sakila.services.domain.Actor;
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
@Path("actor")
@Produces(MediaType.APPLICATION_JSON)
public class ActorEndpoint {
    @Inject
    private ActorServices actorservices;
    
    @GET
    public Response FindAll(){
        List<Actor> actories = actorservices.findAll();
        return Response.ok(actories).build();
    }
    
    @GET
    @Path("by-name")
    public Response findByName(@QueryParam("name") String name){
        List<Actor> actors = actorservices.findByName(name);
        return Response.ok(actors).build();
    }
    
}
