package com.algorand.starter.demo.cryptopayment.model;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Value {

	@NotNull
	@Min(1)
	@Max(999999999)
	private Integer amount;
	@NotNull
	@Size(min = 3, max = 3)
	private String currency;
	@Min(0)
	@Max(999999999)
	private Integer cashbackAmount;
	@Min(0)
	@Max(999999999)
	private Integer gratuityAmount;
	@Min(0)
	@Max(999999999)
	private Integer donationAmount;
	@Valid
	private Dcc dcc;
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getCashbackAmount() {
		return cashbackAmount;
	}
	public void setCashbackAmount(Integer cashbackAmount) {
		this.cashbackAmount = cashbackAmount;
	}
	public Integer getGratuityAmount() {
		return gratuityAmount;
	}
	public void setGratuityAmount(Integer gratuityAmount) {
		this.gratuityAmount = gratuityAmount;
	}
	public Integer getDonationAmount() {
		return donationAmount;
	}
	public void setDonationAmount(Integer donationAmount) {
		this.donationAmount = donationAmount;
	}
	public Dcc getDcc() {
		return dcc;
	}
	public void setDcc(Dcc dcc) {
		this.dcc = dcc;
	}




}