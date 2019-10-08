package com.wp.transport.dao;

import java.util.List;

import com.wp.transport.entities.Vehicle;

public interface VehicleDAO {
	public boolean addVehicle(Vehicle vehicle);

	public Vehicle deleteVehicle(Vehicle vehicle);

	public Vehicle searchVehicle(String registrationNo );

	public List<Vehicle> getVehicleList(int transporterId);

	public void updateVehicle(Vehicle vehicle);

}
