package com.algorand.starter.demo.cryptopayment.model;


public enum TransactionOutcome {

    SUCCESS("success"),
    DECLINE("decline");
	
	private final String value;
	
	TransactionOutcome(String outcome){
		value = outcome;
	}
	
	public String getValue() {
		return value;
	}	

}