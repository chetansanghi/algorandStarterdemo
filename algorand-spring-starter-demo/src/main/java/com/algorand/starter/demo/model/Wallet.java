package com.algorand.starter.demo.model;

public class Wallet {

	private String idempotencyKey;
	private String description;
	
	public Wallet(String idempotencyKey, String description) {
		super();
		this.idempotencyKey = idempotencyKey;
		this.description = description;
	}
	public String getIdempotencyKey() {
		return idempotencyKey;
	}
	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
