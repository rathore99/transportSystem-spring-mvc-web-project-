package com.wp.transport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int userId;
	@Size(min=3,max=20)
	private String userName;
	@NotEmpty
	@Email
	private String email;
	@NotEmpty
	private String mobileNo;
	private String companyName;
	@NotNull
	@Size(min=3,max=20)
	private String firstName;
	@NotNull
	@Size(min=3,max=20)
	private String lastName;
	@NotNull
	@Size(min=6,max=20)
	private String password;
	private String imagePath;

	
	
	

	public User(int userId, String userName, String email, String mobileNo, String companyName, String firstName,
			String lastName, String password, String imagePath) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.companyName = companyName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.imagePath = imagePath;
	}


	public String getImagePath() {
		return imagePath;
	}


	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}


	public User() {
		super();
	}
	

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
