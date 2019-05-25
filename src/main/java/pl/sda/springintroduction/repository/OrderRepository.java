package pl.sda.springintroduction.repository;

import pl.sda.springintroduction.model.Order;

import java.util.Optional;

public interface OrderRepository {

    public Order save(Order order);

    Optional<Order> findById(long orderId);

}