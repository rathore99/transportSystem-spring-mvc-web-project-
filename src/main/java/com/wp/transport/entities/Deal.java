package com.wp.transport.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Deal {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int dealId;
	private String source;
	private String destination;
	private int price;
	private int distance;
	private Date availableDate;
	private Date postTime;
	private boolean status; 
	@ManyToOne
	@JoinColumn(name="vehicleId")
	private Vehicle vehicle;
	@ManyToOne
	@JoinColumn(name="transporterId")
	private Transporter transporter;
	
	
	
	
	@Override
	public String toString() {
		return "Deal [dealId=" + dealId + ", source=" + source + ", destination=" + destination + ", price=" + price
				+ ", distance=" + distance + ", availableDate=" + availableDate + ", postTime=" + postTime + ", status="
				+ status + "]";
	}
	public Deal(int dealId) {
		super();
		this.dealId = dealId;
	}
	public Deal() {
		super();
	}
	public Deal(int dealId, String source, String destination, int price, int distance, Date availableDate,
			Date postTime, boolean status) {
		super();
		this.dealId = dealId;
		this.source = source;
		this.destination = destination;
		this.price = price;
		this.distance = distance;
		this.availableDate = availableDate;
		this.postTime = postTime;
		this.status = status;
	}
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public Date getAvailableDate() {
		return availableDate;
	}
	public void setAvailableDate(Date availableDate) {
		this.availableDate = availableDate;
	}
	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public Transporter getTransporter() {
		return transporter;
	}
	public void setTransporter(Transporter transporter) {
		this.transporter = transporter;
	}
	
	
	
}
