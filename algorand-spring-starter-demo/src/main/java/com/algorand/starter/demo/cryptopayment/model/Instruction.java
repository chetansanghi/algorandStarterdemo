package com.algorand.starter.demo.cryptopayment.model;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instruction {
	private TransactionType subTransactionType;
	@NotNull
	@Valid
	private Value value;
	@Valid
	private Narrative narrative;
	private  PosEntryModeAuthorisation posEntryMode;
	@Size(min = 2,max = 2)
	private String reasonOnlineCode;
	@NotNull
	@Valid
	private PaymentInstrument paymentInstrument;
	
	public TransactionType getSubTransactionType() {
		return subTransactionType;
	}
	public void setSubTransactionType(TransactionType subTransactionType) {
		this.subTransactionType = subTransactionType;
	}
	public Value getValue() {
		return value;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	public Narrative getNarrative() {
		return narrative;
	}
	public void setNarrative(Narrative narrative) {
		this.narrative = narrative;
	}
	public PosEntryModeAuthorisation getPosEntryMode() {
		return posEntryMode;
	}
	public void setPosEntryMode(PosEntryModeAuthorisation posEntryMode) {
		this.posEntryMode = posEntryMode;
	}
	public String getReasonOnlineCode() {
		return reasonOnlineCode;
	}
	public void setReasonOnlineCode(String reasonOnlineCode) {
		this.reasonOnlineCode = reasonOnlineCode;
	}
	public PaymentInstrument getPaymentInstrument() {
		return paymentInstrument;
	}
	public void setPaymentInstrument(PaymentInstrument paymentInstrument) {
		this.paymentInstrument = paymentInstrument;
	}


}