package com.wp.transport.services;

import java.util.List;

import com.wp.transport.entities.Vehicle;

public interface VehicleService {

	public boolean addVehicle(Vehicle vehicle);

	public Vehicle deleteVehicle(Vehicle vehicle);

	public void updateVehicle(Vehicle vehicle);

	public Vehicle getVehicle(String registrationNo);

	public List<Vehicle> show(int transporterId);

}
