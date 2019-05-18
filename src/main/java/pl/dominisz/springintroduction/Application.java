package pl.dominisz.springintroduction;

import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.Order;
import pl.dominisz.springintroduction.model.OrderItem;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.service.BillingService;
import pl.dominisz.springintroduction.service.CreditCardBillingService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {

        BillingService billingService = new CreditCardBillingService();

        Order order = new Order();
        OrderItem hotdog = new OrderItem("Hot dog", new BigDecimal("3.59"));
        OrderItem coffee = new OrderItem("Coffee", new BigDecimal("4.99"));
        order.addItem(hotdog);
        order.addItem(coffee);

        CreditCard creditCard = new CreditCard("Imie", "Nazwisko", "123", LocalDate.of(2022, 5, 1));

        Receipt receipt = billingService.chargeOrder(order, creditCard);

        System.out.println(receipt);
    }

}