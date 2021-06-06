package edu.pingpong.activerecordmultipletables;

import java.util.Set;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import edu.pingpong.activerecordmultipletables.domain.Orders;
import edu.pingpong.activerecordmultipletables.service.ServiceOrders;

@Path("/shop")
public class ShopResource {

    @Inject
    ServiceOrders service;

    @GET 
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello to the Testing Shop";
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Set<Orders> listOrders() {
        return service.listOrders();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Orders> addOrder(Orders order) {
        service.addOrder(order);
        return service.listOrders();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Set<Orders> removeOrder(Orders order) {
        service.removeOrder(order.getId());
        return service.listOrders();
    }
}