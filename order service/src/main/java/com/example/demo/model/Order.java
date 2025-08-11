package com.example.demo.model;

public class Order {
 private String stockSymbol;
 private int quantity;

 // Constructors
 public Order() {}

 public Order(String stockSymbol, int quantity) {
     this.stockSymbol = stockSymbol;
     this.quantity = quantity;
 }

 // Getters and Setters
 public String getStockSymbol() {
     return stockSymbol;
 }

 public void setStockSymbol(String stockSymbol) {
     this.stockSymbol = stockSymbol;
 }

 public int getQuantity() {
     return quantity;
 }

 public void setQuantity(int quantity) {
     this.quantity = quantity;
 }
}
