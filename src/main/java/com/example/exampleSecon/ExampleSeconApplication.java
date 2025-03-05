package com.example.exampleSecon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ExampleSeconApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExampleSeconApplication.class, args);
	}

}
