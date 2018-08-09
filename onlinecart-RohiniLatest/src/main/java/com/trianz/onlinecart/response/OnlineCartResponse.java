package com.trianz.onlinecart.response;

import com.trianz.onlinecart.bean.User;

import java.util.List;
import java.util.Map;

import com.trianz.onlinecart.bean.Product;

public class OnlineCartResponse {


	private String status;
	private String message;
	/**
	 * you can define generic custom object
	 */
	private User user;
	private List<Product> products;
	private List<String> categories;
	private Map<Product, Integer> cart;
	private Map<Product, Integer> wishlist;
	private List<Map<Product, Integer>> orders;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public Map<Product, Integer> getCart() {
		return cart;
	}
	public void setCart(Map<Product, Integer> cart) {
		this.cart = cart;
	}
	public Map<Product, Integer> getWishlist() {
		return wishlist;
	}
	public void setWishlist(Map<Product, Integer> wishlist) {
		this.wishlist = wishlist;
	}
	public List<Map<Product, Integer>> getOrders() {
		return orders;
	}
	public void setOrders(List<Map<Product, Integer>> orders) {
		this.orders = orders;
	}
		
}
