package com.algorand.starter.demo.cryptopayment.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorisationRequest {

	@NotNull
	private String transactionReference;
	private Date transactionDateTime;
	@NotNull
	@Valid
	private Paypoint paypoint;
	@NotNull
	@Valid
	private Instruction instruction;
	public String getTransactionReference() {
		return transactionReference;
	}
	public void setTransactionReference(String transactionReference) {
		this.transactionReference = transactionReference;
	}
	public Date getTransactionDateTime() {
		return transactionDateTime;
	}
	public void setTransactionDateTime(Date transactionDateTime) {
		this.transactionDateTime = transactionDateTime;
	}
	public Paypoint getPaypoint() {
		return paypoint;
	}
	public void setPaypoint(Paypoint paypoint) {
		this.paypoint = paypoint;
	}
	public Instruction getInstruction() {
		return instruction;
	}
	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}


}