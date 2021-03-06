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
package com.vasslatam.sakila.services.endopoints;

import com.vasslatam.sakila.services.CustomerServices;
import com.vasslatam.sakila.services.domain.Customer;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;


@Path("customer")
@Produces(APPLICATION_JSON)
public class CustomerEndpoint {

    @Inject
    private CustomerServices customerService;

    @GET
    public Response findByName(@QueryParam("name") String name) {
        List<Customer> customers = customerService.findByName(name);
        return Response.ok(customers).build();
    }
}
