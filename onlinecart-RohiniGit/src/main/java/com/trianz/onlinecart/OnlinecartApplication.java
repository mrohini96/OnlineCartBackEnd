package com.trianz.onlinecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.trianz.onlinecart.controller"})
public class OnlinecartApplication {
	public static void main(String[] args) {
		SpringApplication.run(OnlinecartApplication.class, args);
	}
}