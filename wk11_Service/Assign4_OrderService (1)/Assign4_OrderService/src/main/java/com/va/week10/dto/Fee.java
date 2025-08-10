package com.va.week10.dto;

import java.time.LocalDateTime;

public class Fee {
    private String feeId;
    private boolean feeType;
    private double feeAmt;
    private double feeSalesTax;
    private LocalDateTime feeDate = LocalDateTime.now();

    public String getFeeId() { return feeId; }
    public void setFeeId(String feeId) { this.feeId = feeId; }
    public boolean isFeeType() { return feeType; }
    public void setFeeType(boolean feeType) { this.feeType = feeType; }
    public double getFeeAmt() { return feeAmt; }
    public void setFeeAmt(double feeAmt) { this.feeAmt = feeAmt; }
    public double getFeeSalesTax() { return feeSalesTax; }
    public void setFeeSalesTax(double feeSalesTax) { this.feeSalesTax = feeSalesTax; }
    public LocalDateTime getFeeDate() { return feeDate; }
    public void setFeeDate(LocalDateTime feeDate) { this.feeDate = feeDate; }
}
