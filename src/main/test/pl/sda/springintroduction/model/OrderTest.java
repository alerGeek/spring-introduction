package pl.sda.springintroduction.model;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.math.BigDecimal;
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
        OrderItem item1 = new OrderItem("Coffee", 1, new BigDecimal("5.51"));
        OrderItem item2 = new OrderItem("Hot dog", 1, new BigDecimal("4.51"));

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

        OrderItem item1 = new OrderItem("Coffee", 1, price1);
        OrderItem item2 = new OrderItem("Hot dog", 1, price2);

        //when
        order.addItem(item1);
        order.addItem(item2);

        BigDecimal expected = price1.add(price2);
        BigDecimal result = order.getAmount();

        //then
        Assertions.assertEquals(expected, result);
    }
}