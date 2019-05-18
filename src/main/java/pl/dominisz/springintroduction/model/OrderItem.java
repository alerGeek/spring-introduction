package pl.dominisz.springintroduction.model;

import java.math.BigDecimal;

public class OrderItem {
    private String description;
    private int quantity;
    private BigDecimal price;

    public OrderItem(String description, int quantity, BigDecimal price) {
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderItem(String description, BigDecimal price) {
        this(description, 1, price);
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
