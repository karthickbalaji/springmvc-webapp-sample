package com.intuit.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.demo.model.login.LoginResultObject;
import com.intuit.demo.model.login.LoginUserInfo;
import com.intuit.demo.service.AuthenticatorService;

/**
 * Handles requests for the application login page.
 */
@Controller
@RequestMapping("/api")
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	AuthenticatorService authService;

	/**
	 */
    @RequestMapping(method = RequestMethod.POST, value = "login")
    @ResponseBody
    public LoginResultObject login(@RequestBody LoginUserInfo userInfo, HttpServletRequest request,
            HttpServletResponse response) {
    	
    	LoginResultObject result = new LoginResultObject();
    	long authId = authService.checkLogin(userInfo.getUserName(), userInfo.getPassword());

    	result.setAuthId(authId);
    	
    	if(authId == -1) {

    		result.setMessage(LoginResultObject.BAD_CREDENTIALS);
    		logger.warn("User : " + userInfo.getUserName() + "attempted login and failed !!");

    	} else {
    		
    		result.setMessage(LoginResultObject.LOGIN_SUCCESS);
    		logger.info("User : " + userInfo.getUserName() + "logged in successfully !!");
    	}
    	
		return result;
	}
	
	
}
