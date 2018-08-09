package com.trianz.onlinecart.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import com.trianz.onlinecart.bean.User;
import com.trianz.onlinecart.dao.OnlineCartDaoImpl;
import com.trianz.onlinecart.response.OnlineCartRequest;
import com.trianz.onlinecart.response.OnlineCartResponse;

@ComponentScan(basePackages = {"com.trianz.onlinecart","com.trianz.onlinecart.service"})
@Component
public class UserServiceImpl implements UserService {
	
	private final static Logger logger = Logger.getLogger(UserServiceImpl.class);

	private OnlineCartDaoImpl onlineCartDao;

	@Autowired
	public UserServiceImpl(OnlineCartDaoImpl onlineCartDao) {
		this.onlineCartDao = onlineCartDao;
		// TODO Auto-generated constructor stub
	}

	@Override
	public OnlineCartResponse execute(OnlineCartRequest onlineCartRequest) {
		boolean status = false;
		OnlineCartResponse onlineCartResponse = new OnlineCartResponse();
		if("user_login".equals(onlineCartRequest.getOpName())) {
			String userEmail = onlineCartRequest.getUser().getUserEmail();
			String password = onlineCartRequest.getUser().getPassword();
			status = login(userEmail, password);
			if(status) {
				onlineCartResponse.setMessage("User login successful");
			} else {
				onlineCartResponse.setMessage("User login failure");
			}
		} else if("user_view".equals(onlineCartRequest.getOpName())) {
			User user = viewProfile(onlineCartRequest.getUser().getUserEmail());
			if (user!=null) {
				onlineCartResponse.setUser(user);	
				status = true;	
				onlineCartResponse.setMessage("User detail fetched successfully");
			} else {
				onlineCartResponse.setMessage("Error while fetching user detail");
			}
		} else if("user_register".equals(onlineCartRequest.getOpName())) {
			status = register(onlineCartRequest.getUser());
			if(status) {
				onlineCartResponse.setMessage("User registration successful");
			} else {
				onlineCartResponse.setMessage("User registraion failure");
			}
		} else if("user_update".equals(onlineCartRequest.getOpName())) {
			status = updateProfile(onlineCartRequest.getUser());
			if(status) {
				onlineCartResponse.setMessage("User updation successful");
			} else {
				onlineCartResponse.setMessage("User updation failure");
			}
		}		
		onlineCartResponse.setStatus(Boolean.toString(status));
		return onlineCartResponse;
		
	}
	
	@Override
	public boolean login(String user, String password) {
		logger.debug("Inside UserServiceImpl=>login <=> user:" + user + " password:" + password);
		boolean status = false;
		User dbUser = null;
		try {
			dbUser = this.onlineCartDao.getUser(user);
		} catch (Exception e) {
			logger.error("Exception while fetching dbUser" + e);
			return false;
		}
		logger.debug("After dbUser");
		if (dbUser != null) {
			logger.debug("Not null dbUser");
			logger.debug("dbUser <=> user:" + dbUser.getUserEmail() + " password:" + dbUser.getPassword());				
			if (user != null && !"".equals(user) && password != null && !"".equals(password)) {
				logger.debug("Not null password");
				if (user.equals(dbUser.getUserEmail()) && password.equals(dbUser.getPassword())) {
					status = true;
				} else {
					status = false;
				}
			} else {
				status = false;
			}
		} else {
			status = false;
		}
		logger.debug("status: " + status);
		return status;
	}
	
	@Override
	public User viewProfile(String user) {
		logger.debug("Inside UserServiceImpl=>viewProfile <=> user:" + user);
		User dbUser = null;
		try {
			dbUser = this.onlineCartDao.getUser(user);
			if(dbUser!=null) {
				logger.debug(dbUser.getFirstName() + " : " + dbUser.getLastName());		
			}
		} catch (Exception e) {
			logger.error("Exception while fetching user" + e);
		}		
		return dbUser;
	}
	
	@Override
	public boolean register(User user) {
		boolean status = false;
		try {
			status = this.onlineCartDao.registerUser(user);
		} catch (Exception e) {
			logger.error("Exception while user registration" + e);
			return status;
		}
		return status;
	}

	@Override
	public boolean updateProfile(User user) {
		boolean status = false;
		try {
			status = this.onlineCartDao.updateUser(user);
		} catch (Exception e) {
			logger.error("Exception while user updation");
			return status;
		}
		return status;
	}
	

}

