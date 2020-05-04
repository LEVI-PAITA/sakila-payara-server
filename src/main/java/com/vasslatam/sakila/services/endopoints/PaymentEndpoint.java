/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.endopoints;


import com.vasslatam.sakila.services.PaymentServices;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



/**
 *
 * @author Levi
 */
@Path("payment")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PaymentEndpoint {
    @Inject
    private PaymentServices paymentservices;

    
    /*
        public Response createRental(Rental rental){
        rentalservices.create(rental);
        return Response.ok(rental).build();
    }
    */
}
