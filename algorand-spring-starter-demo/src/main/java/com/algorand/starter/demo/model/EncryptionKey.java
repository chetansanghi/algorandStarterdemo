package com.algorand.starter.demo.model;

public class EncryptionKey {

	
	private String keyId;
	private String publicKey;
	
	public EncryptionKey() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EncryptionKey(String keyId, String publicKey) {
		super();
		this.keyId = keyId;
		this.publicKey = publicKey;
	}
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public String getPublicKey() {
		return publicKey;
	}
	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
	
}
