package com.kanth.resttemplateserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ResttemplateServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResttemplateServerApplication.class, args);
	}

/*	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}*/
}
