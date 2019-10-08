package com.wp.transport.entities;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class UserCredentials {
	
	@NotEmpty
	@Email
	private String userName;
	
	@NotEmpty
	private String password;
	
	
	
	public UserCredentials() {
		super();
	}
	public UserCredentials(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
