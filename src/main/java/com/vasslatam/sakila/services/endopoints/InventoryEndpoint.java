/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.endopoints;

import com.vasslatam.sakila.services.InventoryService;
import com.vasslatam.sakila.services.domain.Inventory;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

/**
 *
 * @author USERVASSPERU
 */
@Path("inventory")
@Produces(APPLICATION_JSON)
public class InventoryEndpoint {
    @Inject
    private InventoryService inventoryService;

    @GET
    @Path("in-stock")
    public Response inStock(@QueryParam("inventoryId") int inventoryId) {
        boolean stock = inventoryService.inventoryInStock(inventoryId);
        return Response.ok(stock).build();
    }
    
    @GET
    public Response FinAll(){
        List<Inventory> invetories = inventoryService.findAll();
         return Response.ok(invetories).build();
    }
}
