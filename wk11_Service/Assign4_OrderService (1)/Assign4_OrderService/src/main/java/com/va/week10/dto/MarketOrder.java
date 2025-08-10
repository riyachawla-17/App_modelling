package com.va.week10.dto;

public class MarketOrder {
    private String tickerSymbol;
    private double bid, ask, last, open, close;
    private String typeOfExchange;
    private String confirmationStatus;

    public String getTickerSymbol() { return tickerSymbol; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
    public double getBid() { return bid; }
    public void setBid(double bid) { this.bid = bid; }
    public double getAsk() { return ask; }
    public void setAsk(double ask) { this.ask = ask; }
    public double getLast() { return last; }
    public void setLast(double last) { this.last = last; }
    public double getOpen() { return open; }
    public void setOpen(double open) { this.open = open; }
    public double getClose() { return close; }
    public void setClose(double close) { this.close = close; }
    public String getTypeOfExchange() { return typeOfExchange; }
    public void setTypeOfExchange(String typeOfExchange) { this.typeOfExchange = typeOfExchange; }
    public String getConfirmationStatus() { return confirmationStatus; }
    public void setConfirmationStatus(String confirmationStatus) { this.confirmationStatus = confirmationStatus; }
}
