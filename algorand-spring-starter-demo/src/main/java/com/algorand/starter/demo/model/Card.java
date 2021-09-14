package com.algorand.starter.demo.model;

public class Card {
	
	private String idempotencyKey;
	private String keyId;
	private CardDetails cardDetails;
	private BillingDetails billingDetails;
	private int expMonth;
	private int expYear;
	private Metadata metadata;
	private String encryptedData;
	
	public Card(String idempotencyKey, String keyId, CardDetails cardDetails, BillingDetails billingDetails,
			int expMonth, int expYear, Metadata metadata, String encryptedData) {
		super();
		this.idempotencyKey = idempotencyKey;
		this.keyId = keyId;
		this.cardDetails = cardDetails;
		this.billingDetails = billingDetails;
		this.expMonth = expMonth;
		this.expYear = expYear;
		this.metadata = metadata;
		this.encryptedData = encryptedData;
	}
	public String getIdempotencyKey() {
		return idempotencyKey;
	}
	public void setIdempotencyKey(String idempotencyKey) {
		this.idempotencyKey = idempotencyKey;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	
	public CardDetails getCardDetails() {
		return cardDetails;
	}
	public void setCardDetails(CardDetails cardDetails) {
		this.cardDetails = cardDetails;
	}
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	public BillingDetails getBillingDetails() {
		return billingDetails;
	}
	public void setBillingDetails(BillingDetails billingDetails) {
		this.billingDetails = billingDetails;
	}
	public int getExpMonth() {
		return expMonth;
	}
	public void setExpMonth(int expMonth) {
		this.expMonth = expMonth;
	}
	public int getExpYear() {
		return expYear;
	}
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	
	
}
