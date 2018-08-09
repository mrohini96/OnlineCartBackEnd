package com.trianz.onlinecart.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.trianz.onlinecart.service.OnlineService;;

@ComponentScan(basePackages = {"com.trianz.onlinecart.service","com.trianz.onlinecart"})
@Component
public class OnlineServiceFactory {

	@Resource
	private Map<String, OnlineService> servicesMapping;

	public OnlineService getService(String serviceName) {
		OnlineService service = servicesMapping.get(serviceName);
		return service;
	}
}
