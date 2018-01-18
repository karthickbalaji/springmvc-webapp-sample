package com.intuit.demo.dao;

import java.util.List;
import java.util.Set;

import com.intuit.demo.entity.Registration;
import com.intuit.demo.entity.User;

public interface UserDAO {

	public long checkUserLogin(String username, String password);
	
    public List<User> getAllUsers();
    public User getUser(long id);	
    
    public Set<Registration> getRegistrations(long userId);

}
