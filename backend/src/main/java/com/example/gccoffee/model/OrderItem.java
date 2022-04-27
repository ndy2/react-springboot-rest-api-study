package com.example.gccoffee.model;

import java.util.UUID;

public class OrderItem {
    private UUID productId;
    private Category category;
    private long price;
    private long quantity;

    public OrderItem(UUID productId, Category category, long price, long quantity) {
        this.productId = productId;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public UUID getProductId() {
        return productId;
    }

    public Category getCategory() {
        return category;
    }

    public long getPrice() {
        return price;
    }

    public long getQuantity() {
        return quantity;
    }
}
