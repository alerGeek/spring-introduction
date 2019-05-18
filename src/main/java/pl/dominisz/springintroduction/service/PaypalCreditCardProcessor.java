package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.exception.UnreachableException;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class PaypalCreditCardProcessor implements CreditCardProcessor {

    private Random random = new Random();

    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
        int number = random.nextInt(3);
        switch (number) {
            case 0:
                System.out.println("I'm, charging cart " + creditCard.getNumber() + " for " + amount);
                return new ChargeResult(true, "Successful charge");
            case 1:
                System.out.println("Charging cart " + creditCard.getNumber() + " failed.");
                return new ChargeResult(true, "Successful charge");
            default:
                throw new UnreachableException("Broken network connection");
        }
    }
}
