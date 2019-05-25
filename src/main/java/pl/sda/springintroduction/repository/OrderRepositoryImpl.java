package pl.sda.springintroduction.repository;

import org.springframework.stereotype.Repository;
import pl.sda.springintroduction.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orders = new ArrayList<>();
    private long lastId = 0;

    public Order save(Order order) {
        lastId += 1;
        order.setOrderId(lastId);
        orders.add(order);

        return order;
    }

    @Override
    public Optional<Order> findById(long orderId) {
        return orders.stream()
                .filter(order -> orderId == order.getOrderId())
                .findFirst();
    }
}