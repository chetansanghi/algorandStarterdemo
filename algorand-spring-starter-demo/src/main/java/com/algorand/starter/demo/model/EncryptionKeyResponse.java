package com.algorand.starter.demo.model;

public class EncryptionKeyResponse {
	
	private EncryptionKey data;

	public EncryptionKey getData() {
		return data;
	}

	public void setData(EncryptionKey data) {
		this.data = data;
	}

	public EncryptionKeyResponse(EncryptionKey data) {
		super();
		this.data = data;
	}

	public EncryptionKeyResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
