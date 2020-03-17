package com.wp.transport.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Transporter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int transporterId;
	private String firstName;
	private String lastName;
	@Column(name = "email", unique = true)
	private String email;
	@Column(name = "mobileNo", unique = true)
	private String mobileNo;
	private String password;
	private String address;
	private String gstNo;
	private String panCardNo;
	private String panCard;
	private String gstPaper;
	private boolean status = false;
	
	@OneToMany(mappedBy="transporter",fetch = FetchType.LAZY)
	List<Vehicle>vehicleList = new ArrayList<Vehicle>();

	@OneToMany(mappedBy="transporter",fetch = FetchType.LAZY)
	List<Deal>dealList = new ArrayList<Deal>();

	
	/************************************************************************************************************
	 * Constructors
	 * **********************************************************************************************************
	 */

	public Transporter() {
		super();
	}
	
	public Transporter(int transporterId, String firstName, String lastName, String email, String mobileNo,
			String password, String address, String gstNo, String panCardNo, String panCard,
			String gstPaper, boolean status, List<Vehicle> vehicleList) {
		super();
		this.transporterId = transporterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.address = address;
		this.gstNo = gstNo;
		this.panCardNo = panCardNo;
		this.panCard = panCard;
		this.gstPaper = gstPaper;
		this.status = status;
		this.vehicleList = vehicleList;
	}
	
	

	public Transporter(int transporterId, String firstName, String lastName, String email, String mobileNo,
			String password, String address, String gstNo, String panCardNo, String panCard,
			String gstPaper, boolean status, List<Vehicle> vehicleList, List<Deal> dealList) {
		super();
		this.transporterId = transporterId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		this.address = address;
	
		this.gstNo = gstNo;
		this.panCardNo = panCardNo;
		this.panCard = panCard;
		this.gstPaper = gstPaper;
		this.status = status;
		this.vehicleList = vehicleList;
		this.dealList = dealList;
	}

	public Transporter(int transporterId) {
		super();
		this.transporterId = transporterId;
	}

	/************************************************************************************************************
	 * Getters and setters
	 * **********************************************************************************************************
	 */

	
	
	public String getFirstName() {
		return firstName;
	}

	public List<Deal> getDealList() {
		return dealList;
	}

	public void setDealList(List<Deal> dealList) {
		this.dealList = dealList;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public int getTransporterId() {
		return transporterId;
	}

	public void setTransporterId(int transporterId) {
		this.transporterId = transporterId;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getPanCardNo() {
		return panCardNo;
	}

	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getGstPaper() {
		return gstPaper;
	}

	public void setGstPaper(String gstPaper) {
		this.gstPaper = gstPaper;
	}

	@Override
	public String toString() {
		return "Transporter [transporterId=" + transporterId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", mobileNo=" + mobileNo + ", address=" + address + "]";
	}

	
	
}
