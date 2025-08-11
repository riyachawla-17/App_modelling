package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Document("fees")
public class FeeEntity {
  @Id private String id;
  private BigDecimal total;
  private BigDecimal salesTax;
  private LocalDateTime feeDate = LocalDateTime.now();

  public String getId(){ return id; } public void setId(String id){ this.id=id; }
  public BigDecimal getTotal(){ return total; } public void setTotal(BigDecimal t){ this.total=t; }
  public BigDecimal getSalesTax(){ return salesTax; } public void setSalesTax(BigDecimal s){ this.salesTax=s; }
  public LocalDateTime getFeeDate(){ return feeDate; } public void setFeeDate(LocalDateTime d){ this.feeDate=d; }
}
