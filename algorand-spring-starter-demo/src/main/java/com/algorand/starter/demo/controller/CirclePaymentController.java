package com.algorand.starter.demo.controller;

import java.net.URISyntaxException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.algorand.starter.demo.model.Amount;
import com.algorand.starter.demo.model.Payment;
import com.algorand.starter.demo.model.TransferEntity;
import com.algorand.starter.demo.model.WalletTransfer;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CirclePaymentController {

	@Autowired
	private CircleWalletController circleWalletController;
	
	@PostMapping("cardPayment")
	public String createCardPayment(@RequestBody Payment payment) throws RestClientException, URISyntaxException {
		
		TransferEntity source = new TransferEntity("1000174393", "wallet");
		TransferEntity destination = new TransferEntity("1000174358", "wallet");
		
		WalletTransfer walletTransfer = new WalletTransfer(payment.getIdempotencyKey(), source, destination, payment.getAmount());
		circleWalletController.walletTransferWithPayout(walletTransfer);
		
		return "Success";
	}
	
	
	@PostMapping("cardAccessPayment")
	public String createAccessCardPayment(@RequestBody String paymentRequest) throws RestClientException, URISyntaxException, JsonProcessingException {
		return circleWalletController.accessWalletTransferWithPayout(paymentRequest);
	}
	
}
