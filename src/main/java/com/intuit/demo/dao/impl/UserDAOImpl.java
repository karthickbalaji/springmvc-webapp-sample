package com.intuit.demo.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intuit.demo.dao.UserDAO;
import com.intuit.demo.entity.Registration;
import com.intuit.demo.entity.User;
import com.intuit.demo.util.HibernateUtil;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
    private HibernateUtil hibernateUtil;


	@Override
	public List<User> getAllUsers() {

		return hibernateUtil.fetchAll(User.class);
	}

	@Override
	public User getUser(long id) {

		return hibernateUtil.fetchById(id, User.class);
	
	}

	@Override
	public Set<Registration> getRegistrations(long userId) {
		
		return getUser(userId).getRegistrations();
	}

	@Override
	public long checkUserLogin(String username, String password) {
		
		String[] namedParams = {"username", "password"};
		Object[] params = {username, password};

		//TODO can change to api for single Result
		List result = hibernateUtil.executeSelectNamedQuery("findByUserNameAndPwd", namedParams, params);
		
		if (result != null && !result.isEmpty()){
			
			User user = (User) result.get(0);
			return user.getId();			
		}
		
		return -1;
	}	

}
