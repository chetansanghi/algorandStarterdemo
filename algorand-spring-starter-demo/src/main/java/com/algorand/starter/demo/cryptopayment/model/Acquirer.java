package com.algorand.starter.demo.cryptopayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Acquirer {
  private String acquirerResponseCode;
  private String retrievalReferenceNumber;
  
  public String getAcquirerResponseCode() {
	  return acquirerResponseCode;
  }
  public void setAcquirerResponseCode(String acquirerResponseCode) {
	  this.acquirerResponseCode = acquirerResponseCode;
  }
  public String getRetrievalReferenceNumber() {
	  return retrievalReferenceNumber;
  }
  public void setRetrievalReferenceNumber(String retrievalReferenceNumber) {
	  this.retrievalReferenceNumber = retrievalReferenceNumber;
  }
  
  

}