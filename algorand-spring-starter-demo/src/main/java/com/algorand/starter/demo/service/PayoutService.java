package com.algorand.starter.demo.service;

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
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.algorand.starter.demo.model.Payout;

@Service
public class PayoutService {
	
	@Autowired
	private RestTemplate restTemplate;

	public String payout(Payout payout) throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<Payout> entity = new HttpEntity <> (payout, headers);
		
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/businessAccount/payouts"), HttpMethod.POST, entity, String.class);
		System.out.println("Payout response "+exchange);
		return exchange.getBody();
	}
	
}
