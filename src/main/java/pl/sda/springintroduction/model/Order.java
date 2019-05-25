package pl.sda.springintroduction.model;

import lombok.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Order {

    private long userId;
    private long orderId;
    private List<OrderItem> items;

    public Order(List<OrderItem> items){
        this.items = items;
    }

    public void addItem(OrderItem orderItem) {
        items.add(orderItem);
    }

    public BigDecimal getAmount() {
        BigDecimal sum = BigDecimal.ZERO;
        for (OrderItem item : items) {
            sum = sum.add(item.getPrice().multiply(new BigDecimal(item.getQuantity())));
        }
        return sum;
    }
}
