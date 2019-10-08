package com.wp.transport.dao;

import com.wp.transport.entities.User;

public interface UserDAO {
	public void addUser(User user);
	public void show();	
//	public User getuserDetailsByEmailAndPassword(String userName,String password);
}
