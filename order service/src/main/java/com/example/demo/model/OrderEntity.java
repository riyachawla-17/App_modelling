package com.example.demo.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import java.math.BigDecimal;
import com.example.demo.dto.OrderDTO.OrderType;

@Document("orders")
public class OrderEntity {
    @Id private String id;
    private String tickerSymbol;
    private int quantity;
    private BigDecimal orderPrice;
    private OrderType orderType;

    // getters/setters
    public String getId(){ return id; }
    public void setId(String id){ this.id=id; }
    public String getTickerSymbol(){ return tickerSymbol; }
    public void setTickerSymbol(String t){ this.tickerSymbol=t; }
    public int getQuantity(){ return quantity; }
    public void setQuantity(int q){ this.quantity=q; }
    public BigDecimal getOrderPrice(){ return orderPrice; }
    public void setOrderPrice(BigDecimal p){ this.orderPrice=p; }
    public OrderType getOrderType(){ return orderType; }
    public void setOrderType(OrderType t){ this.orderType=t; }
}
