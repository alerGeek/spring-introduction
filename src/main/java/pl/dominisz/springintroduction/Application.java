package pl.dominisz.springintroduction;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.dominisz.springintroduction.model.*;
import pl.dominisz.springintroduction.service.BillingService;
import pl.dominisz.springintroduction.service.CreditCardBillingService;
import pl.dominisz.springintroduction.service.DatabaseTransactionLog;
import pl.dominisz.springintroduction.service.PaypalCreditCardProcessor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Configuration
@ComponentScan
public class Application {

        public static void main(String[] args) {
            Order order = new Order();
            OrderItem hotdog = new OrderItem("Hot dog", new BigDecimal("3.59"));
            OrderItem coffee = new OrderItem("Coffee", new BigDecimal("4.99"));
            order.addItem(hotdog);
            order.addItem(coffee);

            CreditCard creditCard = new CreditCard("Imie", "Nazwisko", "123", LocalDate.of(2022, 5, 1));

            ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);

            System.out.println("ApplicationContex created!");
            BillingService billingService = context.getBean(BillingService.class);
            Receipt receipt = billingService.chargeOrder(order, creditCard);

            System.out.println(receipt);
        }

}