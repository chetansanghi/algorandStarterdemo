package com.algorand.starter.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.algorand.starter.demo.cryptopayment.model.AuthorisationRequest;
import com.algorand.starter.demo.cryptopayment.model.Card;
import com.algorand.starter.demo.cryptopayment.model.CryptoWallet;
import com.algorand.starter.demo.cryptopayment.model.Instruction;
import com.algorand.starter.demo.cryptopayment.model.PaymentInstrument;
import com.algorand.starter.demo.cryptopayment.model.Value;
import com.algorand.starter.demo.helper.CryptoPaymentMapper;
import com.algorand.starter.demo.model.BankAccount;
import com.algorand.starter.demo.model.Payout;
import com.algorand.starter.demo.model.WireTransfer;

@RestController
public class CircleController {
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("bankAccount")
	public String createBankAccount(@RequestBody BankAccount bankAccount) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<BankAccount> entity = new HttpEntity <> (bankAccount, headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/businessAccount/banks/wires"), HttpMethod.POST, entity, String.class);
		
		return "Bank Account created successfully "+exchange;
		
	}
	
	@GetMapping("bankAccount/{id}")
	public String getBankAccount(@PathVariable String id) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<HttpHeaders> entity = new HttpEntity <> (headers);
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/businessAccount/banks/wires/"+id), HttpMethod.GET, entity, String.class);
		return "Bank Account "+exchange;
	}
	
	@PostMapping("wireTransfer")
	public String wireTransfer(@RequestBody WireTransfer wireTransfer) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<WireTransfer> entity = new HttpEntity <> (wireTransfer, headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/mocks/payments/wire"), HttpMethod.POST, entity, String.class);
		
		return "Bank Transfer done successfully "+exchange;
		
	}
	
	@PostMapping("payout")
	public String payout(@RequestBody Payout payout) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<Payout> entity = new HttpEntity <> (payout, headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/businessAccount/payouts"), HttpMethod.POST, entity, String.class);
		System.out.println("Payout response "+exchange);
		return "Bank Transfer done successfully "+exchange;
	}
	
	public String mapPayment(@RequestBody String paymentRequest) throws Exception {
		String result = "ERROR";
		if( paymentRequest != null && paymentRequest.length() > 0) {
			
			CryptoPaymentMapper cryptoPaymentMapper = new CryptoPaymentMapper();
			
			AuthorisationRequest authRequest = cryptoPaymentMapper.mapPaymentRequest(paymentRequest);
			//cryptoPaymentMapper.unmapRequest(authRequest);
			
			if ( authRequest != null ) {
				
				Instruction instruction = authRequest.getInstruction();
				if ( instruction != null ) {
					PaymentInstrument paymentInstrument = instruction.getPaymentInstrument();
					//cryptoPaymentMapper.unmapRequest(paymentInstrument);
					
					if ( paymentInstrument != null ) {
						System.out.println("Payment Instrument Class Name: " + paymentInstrument.getClass().getName());
						
						if ( paymentInstrument instanceof Card) {
							Card card = (Card)paymentInstrument;
							String pan = card.getPrimaryAccountNumber();
							System.out.println("PAN = " + pan);
						
						}else if ( paymentInstrument instanceof CryptoWallet) {
							CryptoWallet cryptoWallet = (CryptoWallet)paymentInstrument;
							String tokenId = cryptoWallet.getTokenId();
							String provider = cryptoWallet.getProvider();
							String blockChain = cryptoWallet.getBlockchain();
							
							System.out.println("TokenId = " + tokenId);
							System.out.println("Provider = " + provider);
							System.out.println("BlockChain = " + blockChain);							
							
						}
						
					}
					
					
					Value value = instruction.getValue();
					
					if( value != null ) {
						Integer amount = value.getAmount();
						String currency = value.getCurrency();
						
						System.out.println("amount = " + amount);
						System.out.println("currency = " + currency);
						
						result = "SUCCESS";
						
					}
					
				}
			}
		
		}		
		return result;
	}
}
