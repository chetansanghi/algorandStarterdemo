package com.algorand.starter.demo.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
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

import com.algorand.starter.demo.model.Address;
import com.algorand.starter.demo.model.Amount;
import com.algorand.starter.demo.model.CreateWallet;
import com.algorand.starter.demo.model.Destination;
import com.algorand.starter.demo.model.Payout;
import com.algorand.starter.demo.model.WalletTransfer;
import com.algorand.starter.demo.service.PayoutService;

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
	
}
