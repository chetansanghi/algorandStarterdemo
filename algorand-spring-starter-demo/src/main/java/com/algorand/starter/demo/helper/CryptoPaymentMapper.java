package com.algorand.starter.demo.helper;

import java.io.IOException;

import com.algorand.starter.demo.cryptopayment.model.AuthorisationRequest;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CryptoPaymentMapper {

	public AuthorisationRequest mapPaymentRequest(String paymentRequest) throws JsonProcessingException 
	{

		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//				.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, true);
		
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);

		AuthorisationRequest authRequest = 
				mapper.readValue(paymentRequest, AuthorisationRequest.class);
	
//		System.out.println("Authorisation Request == " +  mapper.writeValueAsString(authRequest));
		
		return authRequest;
	}
	
	public String unmapRequest(Object requestElement) throws JsonProcessingException {
		
		String jsonOutput = "";
		ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		jsonOutput = mapper.writeValueAsString(requestElement);
		System.out.println("JSON Output == " +  jsonOutput);
		return jsonOutput;

	}

	public static void main(String[] args) throws IOException{
		
		CryptoPaymentMapper cryptoPaymentMapper = new CryptoPaymentMapper();
		
		String cardPaymentRequest = "{\n" + 
				"  \"transactionReference\":\"2535\",\n" + 
				"  \"transactionDateTime\":1608628360012,\n" + 
				"  \"paypoint\":{\n" + 
				"    \"paypointId\":\"022980012\",\n" + 
				"    \"countryCode\":\"US\",\n" + 
				"    \"deviceSerialNumber\":\"14011990\",\n" + 
				"    \"terminalType\":\"ATTENDED\",\n" + 
				"    \"capabilities\":\"E0F8C8\"\n" + 
				"  },\n" + 
				"  \"instruction\":{\n" + 
				"    \"transactionType\":\"SALE\",\n" + 
				"    \"value\":{\n" + 
				"      \"amount\":1000,\n" + 
				"      \"currency\":\"USD\"\n" + 
				"    },\n" + 
				"    \"narrative\":\"Customer paying using USDC Crypto Card\",\n" + 
				"    \"posEntryMode\":\"MANUAL\",\n" + 
				"    \"reasonOnlineCode\":\"06\",\n" + 
				"    \"paymentInstrument\":{\n" + 
				"      \"type\":\"card\",\n" + 
				"      \"primaryAccountNumber\":\"400740xxxxxx0007\"\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";

		AuthorisationRequest authorisationRequest = null;
		
		authorisationRequest = cryptoPaymentMapper.mapPaymentRequest(cardPaymentRequest);
		cryptoPaymentMapper.unmapRequest(authorisationRequest);
		
		String cryptoCardPaymentRequest = "{\n" + 
				"  \"transactionReference\":\"2535\",\n" + 
				"  \"transactionDateTime\":1608628360012,\n" + 
				"  \"paypoint\":{\n" + 
				"    \"paypointId\":\"022980012\",\n" + 
				"    \"countryCode\":\"US\",\n" + 
				"    \"deviceSerialNumber\":\"14011990\",\n" + 
				"    \"terminalType\":\"ATTENDED\",\n" + 
				"    \"capabilities\":\"E0F8C8\"\n" + 
				"  },\n" + 
				"  \"instruction\":{\n" + 
				"    \"transactionType\":\"SALE\",\n" + 
				"    \"value\":{\n" + 
				"      \"amount\":1000,\n" + 
				"      \"currency\":\"BTC\"\n" + 
				"    },\n" + 
				"    \"narrative\":\"Customer paying using BTC Crypto Card\",\n" + 
				"    \"posEntryMode\":\"MANUAL\",\n" + 
				"    \"reasonOnlineCode\":\"06\",\n" + 
				"    \"paymentInstrument\":{\n" + 
				"      \"type\":\"card\",\n" + 
				"      \"primaryAccountNumber\":\"510242xxxxxx0006\"\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";
		
		authorisationRequest = cryptoPaymentMapper.mapPaymentRequest(cryptoCardPaymentRequest);		
		cryptoPaymentMapper.unmapRequest(authorisationRequest);		
		
		String cryptoWalletPaymentRequest = "{\n" + 
				"  \"transactionReference\":\"2535\",\n" + 
				"  \"transactionDateTime\":1608628360012,\n" + 
				"  \"paypoint\":{\n" + 
				"    \"paypointId\":\"022980012\",\n" + 
				"    \"countryCode\":\"US\",\n" + 
				"    \"deviceSerialNumber\":\"14011990\",\n" + 
				"    \"terminalType\":\"ATTENDED\",\n" + 
				"    \"capabilities\":\"E0F8C8\"\n" + 
				"  },\n" + 
				"  \"instruction\":{\n" + 
				"    \"transactionType\":\"SALE\",\n" + 
				"    \"value\":{\n" + 
				"      \"amount\":1000,\n" + 
				"      \"currency\":\"ETH\"\n" + 
				"    },\n" + 
				"    \"narrative\":\"Customer paying using Bitcoin Crypto Wallet\",\n" + 
				"    \"posEntryMode\":\"BARCODE\",\n" + 
				"    \"reasonOnlineCode\":\"06\",\n" + 
				"    \"paymentInstrument\":{\n" + 
				"      \"type\":\"cryptowallet\",\n" + 
				"      \"tokenId\":\"1234567890ABCDEFGHIJ\",\n" + 
				"      \"provider\":\"cryptopay\",\n" + 
				"      \"blockchain\":\"bitcoin\"\n" + 
				"    }\n" + 
				"  }\n" + 
				"}";
		
		authorisationRequest = cryptoPaymentMapper.mapPaymentRequest(cryptoWalletPaymentRequest);		
		cryptoPaymentMapper.unmapRequest(authorisationRequest);		

	}

}
