package pl.dominisz.springintroduction.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {

    private List<OrderItem> items;

    public Order() {
        this.items = new ArrayList<>();
    }

    public void addItem(OrderItem orderItem){
        items.add(orderItem);
    }

    public BigDecimal getAmount() {
        BigDecimal sum = BigDecimal.ZERO;
        for(OrderItem item : items){
            sum = sum.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return sum;
    }
}
