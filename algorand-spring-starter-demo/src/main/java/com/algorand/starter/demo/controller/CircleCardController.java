package com.algorand.starter.demo.controller;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.bouncycastle.bcpg.ArmoredInputStream;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPublicKey;
import org.bouncycastle.openpgp.bc.BcPGPPublicKeyRingCollection;
import org.bouncycastle.openpgp.operator.bc.BcPGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.bc.BcPublicKeyKeyEncryptionMethodGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.algorand.starter.demo.model.Card;
import com.algorand.starter.demo.model.EncryptionKeyResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class CircleCardController {

	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("cards")
	public String createCard(@RequestBody Card card) throws RestClientException, URISyntaxException, PGPException, IOException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        //headers.setAccept(mediaTypes);
        HttpEntity<Card> entity = new HttpEntity <> (card, headers);
		
        String encryptData = encryptData(card);
        card.setEncryptedData(encryptData);
        
		ResponseEntity<String> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/cards"), HttpMethod.POST, entity, String.class);
		return "Card created successfully "+exchange;
	}
	
	private String encryptData(Card card) throws RestClientException, PGPException, URISyntaxException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		String writeValueAsString = mapper.writeValueAsString(card.getCardDetails());
		System.out.println("writeValue "+writeValueAsString);
	    int bufferSize = 64 * 1024;
	    
	    PGPPublicKey pgpEncryptionKey = getPGPEncryptionKey();
	    
	    PGPEncryptedDataGenerator encryptor = new PGPEncryptedDataGenerator(
	        new BcPGPDataEncryptorBuilder(pgpEncryptionKey.getAlgorithm()));
//	    PGPEncryptedDataGenerator encryptor = new PGPEncryptedDataGenerator(
//		        new BcPGPDataEncryptorBuilder(org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags.CAST5));
	    encryptor.addMethod(new BcPublicKeyKeyEncryptionMethodGenerator(pgpEncryptionKey));
	    byte[] encryptedData;
	    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
	      try (OutputStream output2 = encryptor.open(output, new byte[bufferSize])) {
	        output2.write(writeValueAsString.getBytes(java.nio.charset.StandardCharsets.UTF_8));
	      }
	      encryptedData = output.toByteArray();
	    }
	    
	    byte[] encode = Base64.getEncoder().encode(encryptedData);
	    String encryptedCardDetails = new String(encode);
	    System.out.println("Encrypted data "+encryptedCardDetails);
	    return writeValueAsString;
	}
	
	private PGPPublicKey getPGPEncryptionKey() throws PGPException, RestClientException, URISyntaxException {
	    try {
	    	String publicKey = getEncryptionKey().getData().getPublicKey();
	    	byte[] decode = Base64.getDecoder().decode(publicKey);
	    	
	    	InputStream in = new ByteArrayInputStream(decode);
//			JcaPGPPublicKeyRingCollection pgpPub = new JcaPGPPublicKeyRingCollection(org.bouncycastle.openpgp.PGPUtil
//	                .getDecoderStream(in));
			
			BcPGPPublicKeyRingCollection pgpPub = new BcPGPPublicKeyRingCollection(org.bouncycastle.openpgp.PGPUtil
	                .getDecoderStream(new ArmoredInputStream(in)));
	        // Extract the public key from the ring
	        PGPPublicKey pk = pgpPub.getKeyRings().next().getPublicKey();
	        System.out.println(pk.getAlgorithm());
	        return pk;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private EncryptionKeyResponse getEncryptionKey() throws RestClientException, URISyntaxException {
		HttpHeaders headers = new HttpHeaders();
		 
        headers.set("Authorization", "Bearer QVBJX0tFWTo2M2UxYjI2YmQxMDA5MjE3ZjFlMTVkZjk4OTk1OTA0NTo0ODQ4MDM2M2Y3YjQ3ZDE5MmQ5MjVkZjQ5YjgyOWY5OQ");
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON);
        headers.setAccept(mediaTypes);
        HttpEntity<HttpHeaders> entity = new HttpEntity <> (headers);
		
		ResponseEntity<EncryptionKeyResponse> exchange = restTemplate.exchange(new URI("https://api-sandbox.circle.com/v1/encryption/public"), HttpMethod.GET, entity, EncryptionKeyResponse.class);
		System.out.println("Retrieved key "+exchange.getBody().getData().getKeyId());
		return exchange.getBody();
	}
}
