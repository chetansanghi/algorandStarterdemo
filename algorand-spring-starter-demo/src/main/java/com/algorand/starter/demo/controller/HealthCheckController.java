package com.algorand.starter.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

	@GetMapping("hello")
	public String healthCheck() {
		return "Crypto app is running";
	}
}
