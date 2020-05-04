/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.endopoints;

import com.vasslatam.sakila.services.CategoryServices;
import com.vasslatam.sakila.services.domain.Category;
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
@Path("category")
@Produces(MediaType.APPLICATION_JSON)
public class CategoryEndpoint {
    @Inject
    private CategoryServices categoryservices;
    
    @GET
    @Path("by-category")
    public Response findByCategoria(@QueryParam("categoria") String name){
        List<Category> categories = categoryservices.findByCategoria(name);
        return Response.ok(categories).build();
    }
}
