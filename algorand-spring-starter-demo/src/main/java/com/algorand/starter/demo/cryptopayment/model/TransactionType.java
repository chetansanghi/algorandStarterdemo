package com.algorand.starter.demo.cryptopayment.model;



public enum TransactionType {
	SALE("SALE"),
	REFUND("REFUND"),
	VOID("VOID"),
	SALE_WITH_CASHBACK("SALE_WITH_CASHBACK"),
	CASH("CASH"),
	CASH_ADVANCE("CASH_ADVANCE ");

	private final String value;
	
	TransactionType(String type){
		value = type;
	}

	public String getValue() {
		return value;
	}	

}
