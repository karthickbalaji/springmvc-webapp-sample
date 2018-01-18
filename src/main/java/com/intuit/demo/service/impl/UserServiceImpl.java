package com.intuit.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intuit.demo.dao.UserDAO;
import com.intuit.demo.entity.Registration;
import com.intuit.demo.entity.User;
import com.intuit.demo.model.UserBO;
import com.intuit.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;

	@Override
	public UserBO getUserProfile(long uid) {
		
		UserBO result = new UserBO();
		List<String> coursesOpted = new ArrayList<String>();
		
		User user = userDAO.getUser(uid);
		
		result.setName(user.getName());
		result.setEmail(user.getEmail());
		
		for (Registration reg : user.getRegistrations()) {
			
			coursesOpted.add(reg.getCourse().getName());
		}
		
		result.setCoursesOpted(coursesOpted);

		
		return result;
	}

}
