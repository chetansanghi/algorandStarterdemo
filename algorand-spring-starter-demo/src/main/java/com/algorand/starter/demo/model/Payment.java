package com.algorand.starter.demo.model;

public class Payment {

	private String idempotencyKey;
	private String keyId;
	private String encryptedData;
	private Metadata metadata;
	private Amount amount;
	private String verification;
	private TransferEntity source;
	private String description;
	private String cvv;
	
	public Payment(String idempotencyKey, String keyId, String encryptedData, Metadata metadata, Amount amount,
			String verification, TransferEntity source, String description, String cvv) {
		super();
		this.idempotencyKey = idempotencyKey;
		this.keyId = keyId;
		this.encryptedData = encryptedData;
		this.metadata = metadata;
		this.amount = amount;
		this.verification = verification;
		this.source = source;
		this.description = description;
		this.cvv = cvv;
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
	public String getEncryptedData() {
		return encryptedData;
	}
	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}
	public Amount getAmount() {
		return amount;
	}
	public void setAmount(Amount amount) {
		this.amount = amount;
	}
	public String getVerification() {
		return verification;
	}
	public void setVerification(String verification) {
		this.verification = verification;
	}
	public TransferEntity getSource() {
		return source;
	}
	public void setSource(TransferEntity source) {
		this.source = source;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
}
