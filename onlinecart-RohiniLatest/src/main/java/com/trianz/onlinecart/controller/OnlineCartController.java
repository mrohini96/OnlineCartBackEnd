package com.trianz.onlinecart.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.trianz.onlinecart.bean.User;
import com.trianz.onlinecart.response.OnlineCartRequest;
import com.trianz.onlinecart.response.OnlineCartResponse;
import com.trianz.onlinecart.service.ExecutionService; 


@ComponentScan(basePackages = {"com.trianz.onlinecart","com.trianz.onlinecart.service"})
@Component
@CrossOrigin
@Controller
@RequestMapping(value = "/onlinecart")
public class OnlineCartController {
	
	private final static Logger logger = Logger.getLogger(OnlineCartController.class);
	
	@Autowired
	private ExecutionService executionService;
	
	// USER SERVICES : START *******************************************
	@GetMapping("/user/login")
	@ResponseBody
	public String userLogin(@RequestParam(name="name", required=true) String userEmail, @RequestParam(name="password", required=true) String password) {	  	    
		logger.debug("Inside loginGet <=> user:" + userEmail + " password:" + password);
		OnlineCartRequest onlineCartRequest = new OnlineCartRequest();
		User userObj = new User();
		userObj.setUserEmail(userEmail);
		userObj.setPassword(password);
		onlineCartRequest.setUser(userObj);
		onlineCartRequest.setServiceName("userServiceImpl");
		onlineCartRequest.setOpName("user_login");
		OnlineCartResponse onlineCartResponse = executionService.execute(onlineCartRequest);
		logger.debug("After userService : userLogin");
		return getJsonAsString(onlineCartResponse);
	}
	
	@GetMapping("/user/view")
	@ResponseBody
	public String userView(@RequestParam(name="name", required=true) String userEmail) {	    	
		logger.debug("Inside OnlinecartController : userView");
		OnlineCartRequest onlineCartRequest = new OnlineCartRequest();
		User userObj = new User();
		userObj.setUserEmail(userEmail);
		onlineCartRequest.setUser(userObj);
		onlineCartRequest.setServiceName("userServiceImpl");
		onlineCartRequest.setOpName("user_view");
		OnlineCartResponse onlineCartResponse = executionService.execute(onlineCartRequest);
		logger.debug("After userService : userView");
		return getJsonAsString(onlineCartResponse);
	}
	
	@GetMapping("/user/register")
	@ResponseBody
	public String userRegister(@RequestParam(name="name", required=true) String userEmail, 
							   @RequestParam(name="password", required=true) String password, 
							   @RequestParam(name="firstname", required=true) String firstname,
							   @RequestParam(name="lastname", required=true) String lastname) {	    	
		logger.debug("Inside OnlinecartController : userRegister");
		OnlineCartRequest onlineCartRequest = new OnlineCartRequest();
		User userObj = new User();
		userObj.setUserEmail(userEmail);
		userObj.setPassword(password);
		userObj.setFirstName(firstname);
		userObj.setLastName(lastname);
		onlineCartRequest.setUser(userObj);
		onlineCartRequest.setServiceName("userServiceImpl");
		onlineCartRequest.setOpName("user_register");
		OnlineCartResponse onlineCartResponse = executionService.execute(onlineCartRequest);
		logger.debug("After userService : userRegister");
		return getJsonAsString(onlineCartResponse);
	}
	
	@GetMapping("/user/update")
	@ResponseBody
	public String userUpdate(@RequestParam(name="name", required=true) String userEmail, 
			                 @RequestParam(name="city", required=true) String city,
			                 @RequestParam(name="state", required=true) String state,
			                 @RequestParam(name="country", required=true) String country,
			                 @RequestParam(name="address1", required=true) String address1,
			                 @RequestParam(name="address2", required=true) String address2,
			                 @RequestParam(name="phone", required=true) String phone) {	    	
		logger.debug("Inside OnlinecartController : userUpdate");
		OnlineCartRequest onlineCartRequest = new OnlineCartRequest();
		User userObj = new User();
		logger.debug("city:" + city + ", state:" + state + ", country:" + country + ", address1:" + address1 + ", address2:" + address2 + ", phone:" + phone);
		userObj.setUserEmail(userEmail);
		userObj.setUserCity(city);
		userObj.setUserState(state);
		userObj.setUserCountry(country);
		userObj.setUserAddress1(address1);
		userObj.setUserAddress2(address2);
		userObj.setUserPhone(phone);		
		onlineCartRequest.setUser(userObj);
		onlineCartRequest.setServiceName("userServiceImpl");
		onlineCartRequest.setOpName("user_update");
		OnlineCartResponse onlineCartResponse = executionService.execute(onlineCartRequest);
		logger.debug("After userService : userUpdate");
		return getJsonAsString(onlineCartResponse);
	}
	// USER SERVICES : END *******************************************
	
	
    // PRODUCT SERVICES : START *******************************************
	@GetMapping("/product/view")
	@ResponseBody
	public String productView() {	    	
		logger.debug("Inside OnlinecartController : productView");
		OnlineCartRequest onlineCartRequest = new OnlineCartRequest();
		onlineCartRequest.setServiceName("productServiceImpl");
		onlineCartRequest.setOpName("product_view");
		OnlineCartResponse onlineCartResponse = executionService.execute(onlineCartRequest);
		logger.debug("After productService : productView");
		return getJsonAsString(onlineCartResponse);
	}
	
	@GetMapping("/product/categories")
	@ResponseBody
	public String productCategories() {	    	
		logger.debug("Inside OnlinecartController : productCategories");
		OnlineCartRequest onlineCartRequest = new OnlineCartRequest();
		onlineCartRequest.setServiceName("productServiceImpl");
		onlineCartRequest.setOpName("product_categories");
		OnlineCartResponse onlineCartResponse = executionService.execute(onlineCartRequest);
		logger.debug("After productService : productCategories");
		return getJsonAsString(onlineCartResponse);
	}
	// PRODUCT SERVICES : END *******************************************
	
	
	// WISHLIST SERVICES : START *******************************************
	
	// WISHLIST SERVICES : END *******************************************
	
	
	// CART SERVICES : START *******************************************
	
    // CART SERVICES : END *******************************************
	
	
    // ORDER SERVICES : START *******************************************
	
    // ORDER SERVICES : END *******************************************
	
	// Prepare final JSON String from onlineCartResponse wrapper object
	private String getJsonAsString(OnlineCartResponse onlineCartResponse) {
		Gson gson = new Gson();
		return gson.toJson(onlineCartResponse);
	}
	
}