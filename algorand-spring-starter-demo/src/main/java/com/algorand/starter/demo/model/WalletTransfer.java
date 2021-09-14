package com.algorand.starter.demo.model;

public class WalletTransfer {

	private String idempotencyKey;
	private TransferEntity source;
	private TransferEntity destination;
	private Amount amount;
	
	public WalletTransfer(String idempotencyKey, TransferEntity source, TransferEntity destination, Amount amount) {
		super();
		this.idempotencyKey = idempotencyKey;
		this.source = source;
		this.destination = destination;
		this.amount = amount;
	}
	public String getIdempotencyKey() {
		return idempotencyKey;
	}

	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}

	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public TransferEntity getSource() {
		return source;
	}
	public void setSource(TransferEntity source) {
		this.source = source;
	}
	public TransferEntity getDestination() {
		return destination;
	}
	public void setDestination(TransferEntity destination) {
		this.destination = destination;
	}
	
}
