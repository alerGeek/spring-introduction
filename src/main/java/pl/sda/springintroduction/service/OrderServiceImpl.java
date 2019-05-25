package pl.sda.springintroduction.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.springintroduction.exception.UserNotFoundException;
import pl.sda.springintroduction.model.Order;
import pl.sda.springintroduction.repository.OrderRepository;
import pl.sda.springintroduction.repository.UserRepository;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    public Order create(long userId, Order order) {
        boolean userExist = userRepository.existById(userId);

        if(!userExist){
            throw new UserNotFoundException(userId);
        }

        return orderRepository.save(order);
    }

}
