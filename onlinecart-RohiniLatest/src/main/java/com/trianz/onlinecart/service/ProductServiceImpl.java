
package com.trianz.onlinecart.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.trianz.onlinecart.bean.Product;
import com.trianz.onlinecart.dao.OnlineCartDaoImpl;
import com.trianz.onlinecart.response.OnlineCartRequest;
import com.trianz.onlinecart.response.OnlineCartResponse;

@ComponentScan(basePackages = {"com.trianz.onlinecart","com.trianz.onlinecart.service"})
@Component
public class ProductServiceImpl implements ProductService {

	private final static Logger logger = Logger.getLogger(ProductServiceImpl.class);

	private OnlineCartDaoImpl onlineCartDao;

	@Autowired
	public ProductServiceImpl(OnlineCartDaoImpl onlineCartDao) {
		this.onlineCartDao = onlineCartDao;
	}

	@Override
	public OnlineCartResponse execute(OnlineCartRequest onlineCartRequest) {
		boolean status = false;
		OnlineCartResponse onlineCartResponse = new OnlineCartResponse();
		if("product_view".equals(onlineCartRequest.getOpName())) {		
			onlineCartResponse.setProducts(viewProducts());		
			onlineCartResponse.setMessage("Successfully fetched products");
			status = true;
		} else if("product_categories".equals(onlineCartRequest.getOpName())) {
			onlineCartResponse.setCategories(viewCategories());	
			onlineCartResponse.setMessage("Successfully fetched product categories");
			status = true;
		} 	
		onlineCartResponse.setStatus(Boolean.toString(status));
		return onlineCartResponse;
	}
	
	@Override
	public List<Product> viewProducts() {
		List<Product> productList = new ArrayList<Product>();
		try {
			productList = onlineCartDao.getAllProducts();
		} catch (Exception e) {
			logger.error("Exception while fetching products");	
			productList = null;
		}		
		return productList;
	}
	
	@Override
	public List<String> viewCategories(){
		List<String> categories = new ArrayList<String>();
		try {
			categories = onlineCartDao.getProductCategories();
		} catch (Exception e) {
			logger.error("Exception while fetching product categories");	
			categories = null;
		}	
		return categories;
	}
	
}