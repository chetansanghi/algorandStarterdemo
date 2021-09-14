package com.algorand.starter.demo.cryptopayment.model;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dcc {

  @Size(max = 25)
  private String offerIdentifier;
  @NotNull
  @Size(min = 3,max = 3)
  private String convertedCurrencyCode;
  @NotNull
  @Min(1)@Max(999999999)
  private Integer convertedAmount;
  @NotNull
  @Min(0)
  private Double conversionRate;
  private Date offerDateTime;
  private String provider;
  @Min(0)
  private Double markupPercentage;

}