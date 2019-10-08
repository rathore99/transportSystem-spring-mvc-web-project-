package com.wp.transport.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.transport.dao.UserDAO;
import com.wp.transport.entities.User;

@Service
public class UserServiceImpl implements UserServices {

	@Autowired
	UserDAO userDAO;
	public void addUser(User user) {
		userDAO.addUser(user); 
	
	}
	/*public User validateUserCredential(String userName,String password) {
		User user =userDAO.getuserDetailsByEmailAndPassword(userName,password);
		return user;
	}*/

}
