/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasslatam.sakila.services.endopoints;


import com.vasslatam.sakila.services.CustomerServices;
import com.vasslatam.sakila.services.InventoryService;
import com.vasslatam.sakila.services.PaymentServices;
import com.vasslatam.sakila.services.RentalServices;
import com.vasslatam.sakila.services.StaffServices;
import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Inventory;
import com.vasslatam.sakila.services.domain.Payment;
import com.vasslatam.sakila.services.domain.Rental;
import com.vasslatam.sakila.services.domain.Staff;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
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
@Path("rental")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RentalEndpoint {
    @Inject
    private RentalServices rentalservices;
    @Inject
    private InventoryService inventoryservices;
    @Inject
    private PaymentServices paymentservices;
    @Inject
    private StaffServices staffservices;
    @Inject
    private CustomerServices customerservices;
        
    @GET
    @Path("rental-film")
    public Response RentalFilm(@QueryParam("inventoryId") int inventoryId,
                @QueryParam("customerId") int customerId,
            @QueryParam("staffId") int staffId){
        Rental rental = new Rental();
        Inventory inventory = inventoryservices.findById(inventoryId);
        Staff staff = staffservices.findById(staffId);
        Payment payment = new Payment();
        Customer customer = customerservices.findById(customerId);
        
        if(inventoryservices.inventoryInStock(inventoryId)){
            rentalservices.create(rental,customer,inventory,staff);
            Rental lastRental = rentalservices.lastInsert();
            payment.setAmount(customerservices.getcustomer(customerId));
            paymentservices.create(payment, staff, lastRental, customer);
            return Response.ok(rental).build();
        }else{
            return Response.ok("Sin stock").build();
        }
        
    }
    
          
}
