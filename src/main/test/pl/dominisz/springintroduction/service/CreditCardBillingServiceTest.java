package pl.dominisz.springintroduction.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;
import pl.dominisz.springintroduction.exception.UnreachableException;
import pl.dominisz.springintroduction.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

class CreditCardBillingServiceTest {
    private Order createOrder() {
        Order order = new Order();
        OrderItem item1 = new OrderItem("Coffee", new BigDecimal("5.51"));
        OrderItem item2 = new OrderItem("Hot dog", new BigDecimal("4.51"));
        order.addItem(item1);
        order.addItem(item2);
        return order;
    }

    @Test
    public void shouldSuccessfullyChargeCard() {
        //given
        Order order = createOrder();
        CreditCard creditCard = new CreditCard("Imie", "Nazwisko", "123", LocalDate.of(2022, 5, 1));

        CreditCardProcessor creditCardProcessor = Mockito.mock(CreditCardProcessor.class);
        TransactionLog transactionLog = Mockito.mock(TransactionLog.class);
        CreditCardBillingService creditCardBillingService = new CreditCardBillingService(creditCardProcessor, transactionLog);

        //when
        Mockito.when(creditCardProcessor.charge(creditCard, order.getAmount()))
                .thenReturn(new ChargeResult(true, "successful"));
        Receipt receipt = creditCardBillingService.chargeOrder(order, creditCard);
        BigDecimal result = receipt.getAmount();

        //then
        Assertions.assertTrue(receipt.isSuccesful());
        Assertions.assertEquals(new BigDecimal("10.02"), result);
    }

    @Test
    public void shouldFailedChargeCard() {
        //given
        Order order = createOrder();
        CreditCard creditCard = new CreditCard("Imie", "Nazwisko", "123", LocalDate.of(2022, 5, 1));

        CreditCardProcessor creditCardProcessor = Mockito.mock(CreditCardProcessor.class);
        TransactionLog transactionLog = Mockito.mock(TransactionLog.class);
        CreditCardBillingService creditCardBillingService = new CreditCardBillingService(creditCardProcessor, transactionLog);

        //when
        Mockito.when(creditCardProcessor.charge(creditCard, order.getAmount()))
                .thenReturn(new ChargeResult(false, "failed"));
        Receipt receipt = creditCardBillingService.chargeOrder(order, creditCard);
        String result = receipt.getMessage();

        //then
        Assertions.assertFalse(receipt.isSuccesful());
        Assertions.assertEquals("failed", result);
    }

    @Test
    public void shouldthrowException() throws UnreachableException{
        //given
        Order order = createOrder();
        CreditCard creditCard = new CreditCard("Imie", "Nazwisko", "123", LocalDate.of(2022, 5, 1));

        CreditCardProcessor creditCardProcessor = Mockito.mock(CreditCardProcessor.class);
        TransactionLog transactionLog = Mockito.mock(TransactionLog.class);
        CreditCardBillingService creditCardBillingService = new CreditCardBillingService(creditCardProcessor, transactionLog);

        //when
        Mockito.when(creditCardProcessor.charge(creditCard, order.getAmount()))
                .thenThrow(new UnreachableException("broken network"));
        Receipt receipt = creditCardBillingService.chargeOrder(order, creditCard);
        String result = receipt.getMessage();

        //then
        Assertions.assertFalse(receipt.isSuccesful());
        Assertions.assertEquals("broken network", result);
    }

}