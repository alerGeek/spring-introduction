package pl.sda.springintroduction.service;

import org.springframework.stereotype.Service;
import pl.sda.springintroduction.dto.CreateReceiptDto;
import pl.sda.springintroduction.exception.OrderNotFoundException;
import pl.sda.springintroduction.exception.UserNotFoundException;
import pl.sda.springintroduction.model.Order;
import pl.sda.springintroduction.model.Receipt;
import pl.sda.springintroduction.model.User;
import pl.sda.springintroduction.repository.OrderRepository;
import pl.sda.springintroduction.repository.ReceiptRepository;
import pl.sda.springintroduction.repository.UserRepository;

import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReciptService {

    private final BillingService billingService;
    private final ReceiptRepository reciptRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public ReceiptServiceImpl(BillingService billingService, ReceiptRepository reciptRepository, UserRepository userRepository, OrderRepository orderRepository) {
        this.billingService = billingService;
        this.reciptRepository = reciptRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public Optional<Receipt> findById(long id) {
        return reciptRepository.findById(id);
    }

    @Override
    public Receipt create(CreateReceiptDto createReceiptDto) {
        long orderId = createReceiptDto.getOrderId();
        long userId = createReceiptDto.getUserId();

        User user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        Order optionalOrder = orderRepository
                .findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException(orderId));


        Receipt receipt = billingService.chargeOrder(optionalOrder, user.getCreditCard());
        return reciptRepository.save(receipt);
    }
}