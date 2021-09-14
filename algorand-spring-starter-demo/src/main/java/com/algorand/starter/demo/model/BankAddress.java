package com.algorand.starter.demo.model;


public class BankAddress {
	private String bankName;
	private String city;
	private String country;
	private String line1;
	private String line2;
	private String district;

	public BankAddress(String bankName, String city, String country, String line1, String line2, String district) {
		super();
		this.bankName = bankName;
		this.city = city;
		this.country = country;
		this.line1 = line1;
		this.line2 = line2;
		this.district = district;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
}
