package pl.sda.springintroduction.service;

import pl.sda.springintroduction.model.Order;

public interface OrderService {
    Order create(long userId, Order order);

}
