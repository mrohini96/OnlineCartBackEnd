package com.trianz.onlinecart.dao;

import java.util.List;

import com.trianz.onlinecart.bean.Product;
import com.trianz.onlinecart.bean.User;

public interface OnlineCartDao {
	
	// User Service methods [Login | Registration | Account Details]
	User getUser(String user) throws Exception;	
	boolean registerUser(User user) throws Exception;
	boolean updateUser(User user) throws Exception;
	
	// Product Service methods
	List<Product> getAllProducts() throws Exception;
	List<String> getProductCategories() throws Exception;	
	
	// WishList Service methods
//	List<Product> getAllWishListProducts();
//	boolean addProductsToWishList(List<Product> products);
//	boolean removeProductsFromWishList(List<Product> products);

	// Cart Service methods
//	Map<Product, Integer> getAllCartProducts();
//	boolean addProductsToCart(Map<Product, Integer> productCountMap);
//	boolean removeProductsFromCart(Map<Product, Integer> productCountMap);
	
	
	// Payment Service methods
//	boolean pay(amount);

	// Order Service methods
//	Integer createOrder(Map<Integer, Integer> productCountMap);
//	Order  getOrder(Map );
	

}
