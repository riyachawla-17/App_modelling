package com.example.demo.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class FeeDTO {
    public enum FeeType { COMMISSION, ECN, SALES_TAX, TOTAL }
    @NotNull private FeeType feeType;
    @NotNull @DecimalMin("0.00")
    private BigDecimal feeAmt;
    private BigDecimal feeSalesTax;
    private LocalDateTime feeDate = LocalDateTime.now();

    public FeeType getFeeType() { return feeType; }
    public void setFeeType(FeeType feeType) { this.feeType = feeType; }
    public BigDecimal getFeeAmt() { return feeAmt; }
    public void setFeeAmt(BigDecimal feeAmt) { this.feeAmt = feeAmt; }
    public BigDecimal getFeeSalesTax() { return feeSalesTax; }
    public void setFeeSalesTax(BigDecimal feeSalesTax) { this.feeSalesTax = feeSalesTax; }
    public LocalDateTime getFeeDate() { return feeDate; }
    public void setFeeDate(LocalDateTime feeDate) { this.feeDate = feeDate; }
}
