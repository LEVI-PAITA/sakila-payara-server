/*
 * Copyright 2020 Diego Silva Limaco <diego.silva at apuntesdejava.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vasslatam.sakila.services;

import com.vasslatam.sakila.services.domain.Actor;
import com.vasslatam.sakila.services.domain.Customer;
import com.vasslatam.sakila.services.domain.Film;
import com.vasslatam.sakila.services.domain.Film_actor;
import com.vasslatam.sakila.services.domain.Inventory;
import com.vasslatam.sakila.services.domain.Payment;
import com.vasslatam.sakila.services.domain.Rental;
import com.vasslatam.sakila.services.domain.Staff;
import com.vasslatam.sakila.services.repositories.ActorRepository;
import com.vasslatam.sakila.services.repositories.JPAProvider;
import com.vasslatam.sakila.services.type.Rating;
import com.vasslatam.sakila.util.DataSourceProvider;
import java.util.List;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.assertFalse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(Arquillian.class)
public class ArquillianTest {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ArquillianTest.class);

    @Inject
    private ActorRepository actorRepository;

    @Inject
    private CustomerServices customerService;
    
    @Inject
    private filmServices filmservice;
    
    @Inject
    private InventoryService inventoryservice;
    
    @Inject
    private StaffServices staffservice;
    
    @Inject
    private RentalServices rentalservice;
    
    @Inject
    private PaymentServices paymentservice;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "sakila.war")
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addClasses(
                        DataSourceProvider.class,
                        JPAProvider.class
                )
                .addPackage(ActorRepository.class.getPackage())
                .addPackage(CustomerServices.class.getPackage())
                .addPackage(Actor.class.getPackage())
                .addPackages(true, Rating.class.getPackage())
                
                .addPackage(Film.class.getPackage())
                .addPackage(Film_actor.class.getPackage())
                .addPackage(Staff.class.getPackage())
                .addPackage(Inventory.class.getPackage())
                .addPackage(Payment.class.getPackage())
                .addPackage(Rental.class.getPackage())
                .addPackage(filmServices.class.getPackage())
                .addPackage(InventoryService.class.getPackage())
                .addPackage(StaffServices.class.getPackage())
                .addPackage(RentalServices.class.getPackage())
                .addPackage(PaymentServices.class.getPackage());
                   
        
    }
    
    @Test
    @UsingDataSet("datasets/actors.json")
    public void findActor() {
        LOGGER.info("----- PROBANDO BUSQUEDA DE ACTORES -----");
        List<Actor> actors = actorRepository.findByName("ADA");
        assertFalse(actors.isEmpty());
        LOGGER.info("total actores:{}", actors.size());
    }

    @Test
    @UsingDataSet("datasets/customers.json")
    public void findCustomer() {
        LOGGER.info("----- PROBANDO BUSQUEDA DE CLIENTE -----");
        List<Customer> customers = customerService.findByName("Albert Tesla");
        assertFalse(customers.isEmpty());
        LOGGER.info("total customers:{}", customers.size());
    }
    
    @Test
    @UsingDataSet({"datasets/films.json",
    "datasets/actors.json",
    "datasets/film_actors.json"})
    public void findByFilm(){
        LOGGER.info("-------- PROBANDO BUSQUEDA DE ACTORES POR PELICULA --------");
        Rating ra = null;
        List<Film_actor> film_actors = filmservice.findByFilm("JHON","A Epic Drama of a Feminis","ACADEMY DINOSAUR",ra.PG);
        assertFalse(film_actors.isEmpty());
        LOGGER.info("Total FILM ACTOR:{}",film_actors.size());
        
    }
    
    
    @Test
    @UsingDataSet({"datasets/customers.json",
    "datasets/films.json",
    "datasets/staffs.json",
    "datasets/stores.json",
    "datasets/inventorys.json",
    "datasets/payments.json"})    
    public void rentalfilm(){
        LOGGER.info("-------- PROBANDO RENTAS DE DVDS --------");
        Rental rental = new Rental();
        Inventory inventory = inventoryservice.findById(1);
        
        Staff staff = staffservice.findById(1);
        Payment payment = new Payment();
        Customer customer = customerService.findById(1);
        
        rentalservice.create(rental, customer, inventory, staff);
        Rental lastRental = rentalservice.lastInsert();
        //payment.setAmount(customerService.getcustomer(1));
        paymentservice.create(payment, staff, lastRental, customer);
    
        LOGGER.info("Resultado:{}", rental);

    }
    
    

}
