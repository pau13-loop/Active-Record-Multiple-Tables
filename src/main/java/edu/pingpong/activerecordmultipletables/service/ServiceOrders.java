package edu.pingpong.activerecordmultipletables.service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.enterprise.context.ApplicationScoped;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import edu.pingpong.activerecordmultipletables.domain.Items;
import edu.pingpong.activerecordmultipletables.domain.Orders;
import edu.pingpong.activerecordmultipletables.domain.Users;
import io.vertx.core.cli.Option;

@ApplicationScoped
public class ServiceOrders {
    
    public ServiceOrders() {}

    public Set<Orders> listOrders() {
        Stream<Orders> orders = Orders.streamAll();
        return orders.collect(Collectors.toSet());
    }

    public void addOrder(Orders order) {
        Optional<Items> item = Items.find("item_name", order.items.getItem_name()).firstResultOptional();
        if (item.isPresent()) {
            order.items = item.get();
        } else {
            order.items.persist();
        }
        order.persist();
    }

    public void removeOrder(Long id) {
        Optional<Orders> order = Orders.find("id", id).firstResultOptional();
        if (order.isPresent()) {
            order.get().delete();
        }
    }
}
