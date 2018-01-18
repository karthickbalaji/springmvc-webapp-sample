package com.intuit.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.demo.model.UserBO;
import com.intuit.demo.service.UserService;

/**
 * Handles requests for the user information.
 */
@Controller 
@RequestMapping("/api")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/{uid}", method = RequestMethod.GET)
	@ResponseBody
	public UserBO getUserProfile(@PathVariable("uid") long userId) {
		logger.info("UserController :: getUserProfile()");
		
		return userService.getUserProfile(userId);
	}

}
