package com.algorand.starter.demo.cryptopayment.model;

public enum PayPointTerminalType { 	

	ATTENDED_ONLINE("21"), ATTENDED("22"), ATTENDED_OFFLINE("23"), UNATTENDED_ONLINE("24"), UNATTENDED("25"), UNATTENDED_OFFLINE("26");

	private final String value;
	
	PayPointTerminalType(String terminalType){
		value = terminalType;
	}
	
	public String getValue() {
		return value;
	}
	
}