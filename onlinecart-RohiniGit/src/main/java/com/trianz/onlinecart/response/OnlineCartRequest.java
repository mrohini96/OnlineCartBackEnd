package com.trianz.onlinecart.response;

import com.trianz.onlinecart.bean.User;
import com.trianz.onlinecart.bean.WishList;

public class OnlineCartRequest {
	
	private String serviceName;
	private String opName;
	
	private User user;
	private WishList wishlistObj;


	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public String getOpName() {
		return opName;
	}
	public void setOpName(String opName) {
		this.opName = opName;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setwishlist(WishList wishlistObj) {
		this.wishlistObj = wishlistObj;
		
	}
	
		
}
