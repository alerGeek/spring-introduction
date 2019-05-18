package pl.dominisz.springintroduction;

import pl.dominisz.springintroduction.model.*;
import pl.dominisz.springintroduction.service.BillingService;
import pl.dominisz.springintroduction.service.CreditCardBillingService;
import pl.dominisz.springintroduction.service.DatabaseTransactionLog;
import pl.dominisz.springintroduction.service.PaypalCreditCardProcessor;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {

        PaypalCreditCardProcessor paypalCreditCardProcessor = new PaypalCreditCardProcessor();
        DatabaseTransactionLog databaseTransactionLog = new DatabaseTransactionLog();

        BillingService billingService = new CreditCardBillingService(paypalCreditCardProcessor, databaseTransactionLog);

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