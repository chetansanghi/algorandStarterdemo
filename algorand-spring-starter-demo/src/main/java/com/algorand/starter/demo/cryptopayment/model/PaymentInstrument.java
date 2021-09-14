package com.algorand.starter.demo.cryptopayment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")

@JsonSubTypes({@Type(value = Token.class, name = "token"), 
	           @Type(value =  Card.class, name = "card"),
	           @Type(value =  Wallet.class, name = "wallet"),
	           @Type(value =  CryptoWallet.class, name = "cryptowallet"),
		      })
public class PaymentInstrument {

}