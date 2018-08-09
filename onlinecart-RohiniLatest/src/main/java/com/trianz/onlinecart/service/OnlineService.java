package com.trianz.onlinecart.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.trianz.onlinecart.response.OnlineCartRequest;
import com.trianz.onlinecart.response.OnlineCartResponse;

@ComponentScan(basePackages = {"com.trianz.onlinecart","com.trianz.onlinecart.service"})
@Component
public interface OnlineService {

	OnlineCartResponse execute(OnlineCartRequest onlineCartRequest);
	
}
