package com.wp.transport.services;

import java.util.List;

import com.wp.transport.entities.Vehicle;

public interface VehicleService {

	public boolean addVehicle(Vehicle vehicle);

	public Vehicle deleteVehicle(Vehicle vehicle);

	public void updateVehicle(Vehicle vehicle);

	public Vehicle getVehicle(String registrationNo);

	public List<Vehicle> show(int transporterId);

	public List<Vehicle> show();

	public List<String> getAllvehicle(int transporterId);

	public List<Vehicle> getUnapprovedVehicles(boolean status);
	
	public Vehicle getVehicleById(String id);

}
