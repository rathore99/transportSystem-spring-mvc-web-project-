package com.wp.transport.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VehicleType {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String vehicleType;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public VehicleType(int id, String vehicleType) {
		super();
		this.id = id;
		this.vehicleType = vehicleType;
	}
	public VehicleType() {
		super();
	}
	public VehicleType(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "VehicleType [id=" + id + ", vehicleType=" + vehicleType + "]";
	}
		
	
}
