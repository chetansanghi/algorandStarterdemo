package com.algorand.starter.demo.cryptopayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.Valid;

@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {

  private TransactionOutcome transactionOutcome;
  @Valid
  private Issuer issuer;
  private Acquirer acquirer;
  
  public TransactionOutcome getTransactionOutcome() {
	  return transactionOutcome;
  }
  public void setTransactionOutcome(TransactionOutcome transactionOutcome) {
	  this.transactionOutcome = transactionOutcome;
  }
  public Issuer getIssuer() {
	  return issuer;
  }
  public void setIssuer(Issuer issuer) {
	  this.issuer = issuer;
  }
  public Acquirer getAcquirer() {
	  return acquirer;
  }
  public void setAcquirer(Acquirer acquirer) {
	  this.acquirer = acquirer;
  }  
  
  
  
}