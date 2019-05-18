package pl.dominisz.springintroduction.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class OrderTest {

    @Test
    void newOrderShouldBeEmptyAfterCreation() {
        //when
        Order order = new Order();
        List<OrderItem> items = order.getItems();

        //then
        Assertions.assertTrue(items.isEmpty());
        Assertions.assertEquals(BigDecimal.ZERO, order.getAmount());
    }

    @Test
    void addItemshouldAddProductToItems() {
        //given
        Order order = new Order();
        OrderItem item1 = new OrderItem("Coffe", new BigDecimal("5.51"));
        OrderItem item2 = new OrderItem("Hot dog", new BigDecimal("4.51"));

        //when
        order.addItem(item1);
        order.addItem(item2);

        List<OrderItem> expected = Arrays.asList(item1, item2);
        List<OrderItem> items = order.getItems();

        //then
        Assertions.assertEquals(expected, items);
    }

    @Test
    void addItemshouldIncreaseAmount() {
        //given
        Order order = new Order();
        BigDecimal price1 = new BigDecimal("5.51");
        BigDecimal price2 = new BigDecimal("4.51");

        OrderItem item1 = new OrderItem("Coffe", price1);
        OrderItem item2 = new OrderItem("Hot dog", price2);

        //when
        order.addItem(item1);
        order.addItem(item2);

        BigDecimal expected = price1.add(price2);
        BigDecimal result = order.getAmount();

        //then
        Assertions.assertEquals(expected, result);
    }
}