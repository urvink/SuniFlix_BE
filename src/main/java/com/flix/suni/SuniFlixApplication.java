package com.flix.suni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SuniFlixApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuniFlixApplication.class, args);
	}
}
