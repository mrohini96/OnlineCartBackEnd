package com.trianz.onlinecart.bean;

public class WishList {

	private int wishlistId;
	public int getWishlistId() {
		return wishlistId;
	}
	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	private int userId;
	private int productId;
}
