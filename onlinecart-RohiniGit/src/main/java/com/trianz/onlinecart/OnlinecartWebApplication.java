package com.trianz.onlinecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.trianz.onlinecart.controller"})
class OnlinecartWebApplication extends SpringBootServletInitializer {
	
	 @Override
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		 return application.sources(OnlinecartWebApplication.class); 
	 }

	 public static void main(String[] args) throws Exception {
		 SpringApplication.run(OnlinecartWebApplication.class, args);
	 }
}
