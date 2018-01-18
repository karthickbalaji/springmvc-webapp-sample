package com.intuit.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.demo.dao.UserDAO;
import com.intuit.demo.service.AuthenticatorService;

@Service
@Transactional
public class AuthenticatorServiceImpl implements AuthenticatorService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public long checkLogin(String username, String password) {

		return userDAO.checkUserLogin(username, password);
		
	}


}
