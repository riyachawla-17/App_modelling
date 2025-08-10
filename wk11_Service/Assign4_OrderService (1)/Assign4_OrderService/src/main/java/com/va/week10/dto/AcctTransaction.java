package com.va.week10.dto;

import com.va.week10.model.Order;

import java.time.LocalDateTime;
import java.util.UUID;

public class AcctTransaction {
    private String transactionId = UUID.randomUUID().toString();
    private String orderId;
    private String transactionType;
    private String tickerSymbol;
    private double transactionPrice;
    private LocalDateTime orderDateTime;
    private double orderAmt;
    private double balanceAmt;

    public static AcctTransaction from(Order o, MarketOrder m, Fee f){
        AcctTransaction at = new AcctTransaction();
        at.orderId = o.getId();
        at.transactionType = o.getOrderType().name();
        at.tickerSymbol = o.getStockSymbol();
        at.transactionPrice = (m != null && m.getLast() > 0) ? m.getLast() : o.getPrice();
        at.orderDateTime = o.getCreatedAt();
        double base = o.getQuantity() * at.transactionPrice;
        double fee = (f != null) ? f.getFeeAmt() : 0.0;
        at.orderAmt = base + fee;
        at.balanceAmt = 0;
        return at;
    }

    public String getTransactionId() { return transactionId; }
    public void setTransactionId(String transactionId) { this.transactionId = transactionId; }
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }
    public String getTransactionType() { return transactionType; }
    public void setTransactionType(String transactionType) { this.transactionType = transactionType; }
    public String getTickerSymbol() { return tickerSymbol; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
    public double getTransactionPrice() { return transactionPrice; }
    public void setTransactionPrice(double transactionPrice) { this.transactionPrice = transactionPrice; }
    public LocalDateTime getOrderDateTime() { return orderDateTime; }
    public void setOrderDateTime(LocalDateTime orderDateTime) { this.orderDateTime = orderDateTime; }
    public double getOrderAmt() { return orderAmt; }
    public void setOrderAmt(double orderAmt) { this.orderAmt = orderAmt; }
    public double getBalanceAmt() { return balanceAmt; }
    public void setBalanceAmt(double balanceAmt) { this.balanceAmt = balanceAmt; }
}
