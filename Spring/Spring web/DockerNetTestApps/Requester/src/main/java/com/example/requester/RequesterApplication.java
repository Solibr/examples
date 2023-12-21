package com.example.requester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RequesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RequesterApplication.class, args);
	}

}
