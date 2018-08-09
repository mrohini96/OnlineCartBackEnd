package com.trianz.onlinecart.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.trianz.onlinecart.bean.User;

// User Service methods [Login | Registration | Account Details]
@ComponentScan(basePackages = {"com.trianz.onlinecart","com.trianz.onlinecart.service"})
@Component
public interface UserService extends OnlineService {

	public boolean login(String user, String password);
	
	public boolean register(User user);
	
	public User viewProfile(String user);
	
	public boolean updateProfile(User user);
	

}
