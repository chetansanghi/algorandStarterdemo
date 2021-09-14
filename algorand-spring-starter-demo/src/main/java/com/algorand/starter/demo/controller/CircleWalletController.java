package com.algorand.starter.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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

import com.algorand.starter.demo.cryptopayment.model.Acquirer;
import com.algorand.starter.demo.cryptopayment.model.AuthorisationRequest;
import com.algorand.starter.demo.cryptopayment.model.Card;
import com.algorand.starter.demo.cryptopayment.model.CryptoWallet;
import com.algorand.starter.demo.cryptopayment.model.Instruction;
import com.algorand.starter.demo.cryptopayment.model.Issuer;
import com.algorand.starter.demo.cryptopayment.model.PaymentInstrument;
import com.algorand.starter.demo.cryptopayment.model.TransactionOutcome;
import com.algorand.starter.demo.cryptopayment.model.TransactionResponse;
import com.algorand.starter.demo.cryptopayment.model.Value;
import com.algorand.starter.demo.helper.CryptoPaymentMapper;
import com.algorand.starter.demo.model.Address;
import com.algorand.starter.demo.model.Amount;
import com.algorand.starter.demo.model.CreateWallet;
import com.algorand.starter.demo.model.Destination;
import com.algorand.starter.demo.model.Payout;
import com.algorand.starter.demo.model.TransferEntity;
import com.algorand.starter.demo.model.WalletTransfer;
import com.algorand.starter.demo.service.PayoutService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CircleWalletController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private PayoutService payoutService;
	
	@PostMapping("wallets")
	public String createWallet(@RequestBody CreateWallet wallet) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<CreateWallet> entity = new HttpEntity <> (wallet, headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/wallets"), HttpMethod.POST, entity, String.class);
		return "Wallet created successfully "+exchange;
	}
	
	@GetMapping("wallets/{id}")
	public String getWallet(@PathVariable String id) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<HttpHeaders> entity = new HttpEntity<> (headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/wallets/"+id), HttpMethod.GET, entity, String.class);
		return "Wallet retrieved successfully "+exchange;
	}
	
	@PostMapping("wallets/{id}/addresses")
	public String createAddress(@PathVariable String id, @RequestBody Address address) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<Address> entity = new HttpEntity <> (address, headers);
		System.out.println("https://api-sandbox.circle.com/v1/wallets/"+id+"/addresses");
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/wallets/"+id+"/addresses"), HttpMethod.POST, entity, String.class);
		return "Address created successfully "+exchange;
	}
	
	@GetMapping("wallets/{id}/addresses")
	public String getAddresses(@PathVariable String id) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<HttpHeaders> entity = new HttpEntity <> (headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/wallets"+id+"addresses"), HttpMethod.GET, entity, String.class);
		return "Wallet retrieved successfully "+exchange;
	}
	
	@PostMapping("walletTransfer")
	public String walletTransfer(@RequestBody WalletTransfer walletTransfer) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<WalletTransfer> entity = new HttpEntity <> (walletTransfer, headers);
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/transfers"), HttpMethod.POST, entity, String.class);
		return "Transfer created successfully "+exchange;
	}
	
	@PostMapping("walletTransferWithPayout")
	public String walletTransferWithPayout(@RequestBody WalletTransfer walletTransfer) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<WalletTransfer> entity = new HttpEntity <> (walletTransfer, headers);
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/transfers"), HttpMethod.POST, entity, String.class);
		System.out.println("Wallet transfer response "+exchange.getBody());
		Destination destination = new Destination("wire", "ca8a8b29-a4fc-4695-881e-572139d6aa7f");
		Payout payout = new Payout(UUID.randomUUID().toString(), destination, walletTransfer.getAmount());
		String payoutResponse = payoutService.payout(payout);
		System.out.println("Payout response "+payoutResponse);
		return "Transfer created successfully "+exchange;
	}
	
	@PostMapping("accessWalletTransferWithPayout")
	public String accessWalletTransferWithPayout(@RequestBody String paymentRequest) throws RestClientException, URISyntaxException, JsonProcessingException {
		String response = "UNKNOWN";
		CryptoPaymentMapper cryptoPaymentMapper = new CryptoPaymentMapper();
		TransactionResponse transactionResponse = new TransactionResponse();
		transactionResponse.setTransactionOutcome(TransactionOutcome.DECLINE);
		response = cryptoPaymentMapper.unmapRequest(transactionResponse);
		if( paymentRequest != null && paymentRequest.length() > 0) {

			AuthorisationRequest authRequest = cryptoPaymentMapper.mapPaymentRequest(paymentRequest);
			//cryptoPaymentMapper.unmapRequest(authRequest);
			if ( authRequest != null ) {
				Instruction instruction = authRequest.getInstruction();
				if ( instruction != null ) {
					PaymentInstrument paymentInstrument = instruction.getPaymentInstrument();
					//cryptoPaymentMapper.unmapRequest(paymentInstrument);
					String tokenId = "1000175190";
					if ( paymentInstrument != null ) {
						System.out.println("Payment Instrument Class Name: " + paymentInstrument.getClass().getName());
						if ( paymentInstrument instanceof Card) {
							Card card = (Card)paymentInstrument;
							String pan = card.getPrimaryAccountNumber();
							System.out.println("PAN = " + pan);
						}else if ( paymentInstrument instanceof CryptoWallet) {
							CryptoWallet cryptoWallet = (CryptoWallet)paymentInstrument;
							tokenId = cryptoWallet.getTokenId();
							String provider = cryptoWallet.getProvider();
							String blockChain = cryptoWallet.getBlockchain();
							System.out.println("TokenId = " + tokenId);
							System.out.println("Provider = " + provider);
							System.out.println("BlockChain = " + blockChain);	
						}

						Value value = instruction.getValue();
						Amount paymentAmount = null;
						
						if( value != null ) {
							String currency = value.getCurrency();
							String idempotencyKey = UUID.randomUUID().toString();
							
							
							System.out.println("idempotencyKey = " + idempotencyKey);
							System.out.println("currency = " + currency);
							
							
							int authCodeInt = new Random().nextInt(999999);
							
							System.out.println("authCodeInt : " + String.format("%06d", authCodeInt));

							Integer amount = value.getAmount();
							double amountDouble;
							TransferEntity source;
							if (currency.equalsIgnoreCase("ETH")) {
								amountDouble = (amount.intValue())/1000000000;
								source = new TransferEntity(tokenId, "wallet");
							} else {
								amountDouble = (amount.intValue())/100;
								source = new TransferEntity("1000174393", "wallet");
							}
							System.out.println("amount = " + amountDouble);
							paymentAmount = new Amount(String.valueOf(amountDouble), currency);

							TransferEntity destination = new TransferEntity("1000174358", "wallet");
							
							WalletTransfer walletTransfer = new WalletTransfer(idempotencyKey, source, destination, paymentAmount);
							HttpHeaders headers = new HttpHeaders();
					        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
					        headers.setContentType(MediaType.APPLICATION_JSON);
					        
					        List<MediaType> mediaTypes = new ArrayList<>();
					        mediaTypes.add(MediaType.APPLICATION_JSON);
					        headers.setAccept(mediaTypes);
					        HttpEntity<WalletTransfer> entity = new HttpEntity <> (walletTransfer, headers);
							ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/transfers"), HttpMethod.POST, entity, String.class);
							System.out.println("Wallet transfer response "+exchange.getBody());
							Destination wireDestination = new Destination("wire", "ca8a8b29-a4fc-4695-881e-572139d6aa7f");
							
							Amount payoutAmount = walletTransfer.getAmount();
							
							if (currency.equalsIgnoreCase("ETH")) {
								amountDouble = amountDouble * 3359.93;
								payoutAmount = new Amount(String.valueOf(amountDouble), "USD");
							}
							
							Payout payout = new Payout(UUID.randomUUID().toString(), wireDestination, payoutAmount);
							String payoutResponse = payoutService.payout(payout);

							transactionResponse.setTransactionOutcome(TransactionOutcome.SUCCESS);
							Issuer issuerResponse = new Issuer();
							//String authCode = UUID.randomUUID().toString();
							//issuerResponse.setAuthorisationCode(authCode.substring(0, 5));
							issuerResponse.setAuthorisationCode(String.format("%06d", authCodeInt).trim());
							Acquirer acquirer = new Acquirer();
							acquirer.setAcquirerResponseCode("00");
							transactionResponse.setIssuer(issuerResponse);
							transactionResponse.setAcquirer(acquirer);
							response = cryptoPaymentMapper.unmapRequest(transactionResponse);
							System.out.println("Payout response "+response);
						}
					}
					
					
					
				}
			}
		
		}		
		return response;
	}

}
