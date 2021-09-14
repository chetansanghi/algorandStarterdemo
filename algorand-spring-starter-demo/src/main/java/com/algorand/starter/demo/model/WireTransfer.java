package com.algorand.starter.demo.model;

public class WireTransfer {
	
	private String trackingRef;
	
	private Amount amount;
	
	public WireTransfer(String trackingRef, Amount amount) {
		super();
		this.trackingRef = trackingRef;
		this.amount = amount;
	}

	public String getTrackingRef() {
		return trackingRef;
	}

	public void setTrackingRef(String trackingRef) {
		this.trackingRef = trackingRef;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	
	

}
