package com.rest.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApplication {

	public static void main(String[] args) {
		System.out.println("Started ... ");
		SpringApplication.run(RestApplication.class, args);
		System.out.println("End.");
	}

}
