package com.trianz.onlinecart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.trianz.onlinecart.response.OnlineCartRequest;
import com.trianz.onlinecart.response.OnlineCartResponse;

@ComponentScan(basePackages = {"com.trianz.onlinecart","com.trianz.onlinecart.service"})
@Component
public class ExecutionService {

	@Autowired
	private OnlineServiceFactory onlineServiceFactory;

	public OnlineCartResponse execute(OnlineCartRequest onlineCartRequest) {
		OnlineService onlineService = onlineServiceFactory.getService(onlineCartRequest.getServiceName());
		OnlineCartResponse onlineCartResponse = onlineService.execute(onlineCartRequest);	
		return onlineCartResponse;
	}
}
