package com.algorand.starter.demo.model;

public class EncryptedData {
	
	private String number;
	private String cvv;
	
	public EncryptedData(String number, String cvv) {
		super();
		this.number = number;
		this.cvv = cvv;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	
	

}
