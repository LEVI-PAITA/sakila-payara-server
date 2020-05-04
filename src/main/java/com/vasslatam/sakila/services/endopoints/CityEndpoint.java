/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.endopoints;

import com.vasslatam.sakila.services.CityServices;
import com.vasslatam.sakila.services.domain.City;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author USERVASSPERU
 */
@Path("city")
@Produces(MediaType.APPLICATION_JSON)
public class CityEndpoint {
    @Inject
    private CityServices cityservices;
    
    @GET
    public Response FindAll(){
        List<City> cities = cityservices.findAll();
        return Response.ok(cities).build();
    }
}
