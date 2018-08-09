package com.trianz.onlinecart.service;

import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.trianz.onlinecart.bean.Product;

@ComponentScan(basePackages = {"com.trianz.onlinecart","com.trianz.onlinecart.service"})
@Component
public interface ProductService extends OnlineService {	
	
	public List<Product> viewProducts();
	public List<String> viewCategories();
	
}
