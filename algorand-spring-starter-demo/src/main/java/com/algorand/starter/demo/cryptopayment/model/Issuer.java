package com.algorand.starter.demo.cryptopayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Issuer {
  private String authorisationCode;

  public String getAuthorisationCode() {
	  return authorisationCode;
  }

  public void setAuthorisationCode(String authorisationCode) {
	  this.authorisationCode = authorisationCode;
  }
  
  
}