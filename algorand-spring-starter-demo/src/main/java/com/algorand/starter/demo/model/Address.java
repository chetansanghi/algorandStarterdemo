package com.algorand.starter.demo.model;

public class Address {

	private String idempotencyKey;
	private String currency;
	private String chain;
	
	public Address(String idempotencyKey, String currency, String chain) {
		super();
		this.idempotencyKey = idempotencyKey;
		this.currency = currency;
		this.chain = chain;
	}
	public String getIdempotencyKey() {
		return idempotencyKey;
	}
	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getChain() {
		return chain;
	}
	public void setChain(String chain) {
		this.chain = chain;
	}
	
	
}
