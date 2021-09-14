package com.algorand.starter.demo.model;

public class Payout {
	
	private String idempotencyKey;
	private Destination destination;
	private Amount amount;
	
	public Payout(String idempotencyKey, Destination destination, Amount amount) {
		super();
		this.idempotencyKey = idempotencyKey;
		this.destination = destination;
		this.amount = amount;
	}
	public String getIdempotencyKey() {
		return idempotencyKey;
	}
	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}
	public Destination getDestination() {
		return destination;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
	
}
