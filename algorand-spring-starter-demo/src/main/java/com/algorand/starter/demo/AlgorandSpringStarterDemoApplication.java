package com.algorand.starter.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AlgorandSpringStarterDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgorandSpringStarterDemoApplication.class, args);
	}

	 @Bean
	   public RestTemplate getRestTemplate() {
	      return new RestTemplate();
	   }
	
}
