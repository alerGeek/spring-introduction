package pl.sda.springintroduction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.sda.springintroduction.model.Order;
import pl.sda.springintroduction.service.OrderService;

@RestController
//@RequestMapping("/users")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/users/{userId}/orders")
    public Order create(@PathVariable long userId, @RequestBody Order order){
        return orderService.create(userId, order);
    }
}
