package com.algorand.starter.demo.model;

public class BankAccount {

	private String idempotencyKey;
	private String accountNumber;
	private String routingNumber;
	private BillingDetails billingDetails;
	private BankAddress bankAddress;
	
	public BankAccount(String idempotencyKey, String accountNumber, String routingNumber, BillingDetails billingDetails,
			BankAddress bankAddress) {
		super();
		this.idempotencyKey = idempotencyKey;
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
		this.billingDetails = billingDetails;
		this.bankAddress = bankAddress;
	}


	public String getIdempotencyKey() {
		return idempotencyKey;
	}


	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}


	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getRoutingNumber() {
		return routingNumber;
	}
	public void setRoutingNumber(String routingNumber) {
		this.routingNumber = routingNumber;
	}
	public BillingDetails getBillingDetails() {
		return billingDetails;
	}
	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}
	public BankAddress getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(BankAddress bankAddress) {
		this.bankAddress = bankAddress;
	}
	
	
}
