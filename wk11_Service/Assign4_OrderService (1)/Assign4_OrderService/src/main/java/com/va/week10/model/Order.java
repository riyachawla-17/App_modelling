package com.va.week10.model;

import jakarta.validation.constraints.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "orders")
public class Order {
    @Id
    private String id;

    @NotBlank(message = "username is required")
    private String username;

    @NotBlank(message = "stockSymbol is required")
    private String stockSymbol;

    @Min(value = 1, message = "quantity must be >= 1")
    private int quantity;

    @Positive(message = "price must be > 0")
    private double price;

    @NotNull(message = "orderType is required")
    private OrderType orderType;

    private LocalDateTime createdAt = LocalDateTime.now();

    // getters/setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getStockSymbol() { return stockSymbol; }
    public void setStockSymbol(String stockSymbol) { this.stockSymbol = stockSymbol; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public OrderType getOrderType() { return orderType; }
    public void setOrderType(OrderType orderType) { this.orderType = orderType; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
