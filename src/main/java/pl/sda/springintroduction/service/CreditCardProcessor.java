package pl.sda.springintroduction.service;

import pl.sda.springintroduction.model.ChargeResult;
import pl.sda.springintroduction.model.CreditCard;

import java.math.BigDecimal;

public interface CreditCardProcessor {
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount);
}
