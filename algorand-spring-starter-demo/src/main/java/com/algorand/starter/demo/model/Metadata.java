package com.algorand.starter.demo.model;

public class Metadata {

	private String email;
	private String phoneNumber;
	private String sessionId;
	private String ipAddress;
	
	
	public Metadata(String email, String phoneNumber, String sessionId, String ipAddress) {
		super();
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.sessionId = sessionId;
		this.ipAddress = ipAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	
}
