package com.example.demo.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class OrderDTO {
    @NotBlank @Size(max=10)
    private String tickerSymbol;
    @Min(1)
    private int quantity;
    @NotNull @DecimalMin("0.01")
    private BigDecimal orderPrice;
    @NotNull
    private OrderType orderType;

    public enum OrderType { BUY, SELL }

    public String getTickerSymbol() { return tickerSymbol; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public BigDecimal getOrderPrice() { return orderPrice; }
    public void setOrderPrice(BigDecimal orderPrice) { this.orderPrice = orderPrice; }
    public OrderType getOrderType() { return orderType; }
    public void setOrderType(OrderType orderType) { this.orderType = orderType; }
}
