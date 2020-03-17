package com.wp.transport.services;

import java.util.ArrayList;
import java.util.List;

import javax.el.ArrayELResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.transport.dao.VehicleDAO;
import com.wp.transport.entities.Vehicle;
@Service
public class VehicleServiceImpl implements VehicleService {
	@Autowired
	VehicleDAO vehicleDAO;
	public boolean addVehicle(Vehicle vehicle) {
		return vehicleDAO.addVehicle(vehicle);
	}

	public Vehicle deleteVehicle(Vehicle vehicle) {
		return vehicleDAO.deleteVehicle(vehicle);
	}

	public void updateVehicle(Vehicle vehicle) {
		vehicleDAO.updateVehicle(vehicle);	
	}

	public List<Vehicle> show(int transporterId) {
	return	vehicleDAO.getVehicleList(transporterId);
	}

	public Vehicle getVehicle(String registrationNo) {
		Vehicle v=vehicleDAO.searchVehicle(registrationNo);
		if(v!=null) {
			return v;
		}
		return null;
		
	}
	
	public List<String> getAllvehicle(int transporterId){
		System.out.println("--------------------------------------!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		List<String> data = vehicleDAO.getAllRegNo(transporterId);
		System.out.println(data.size());
		
		return data;
	}

	public List<Vehicle> show() {
	
		return vehicleDAO.getVehicleList();
	}
	public List<Vehicle>getUnapprovedVehicles(boolean status){
		return vehicleDAO.getUnapprovedVehicles(status);
	}

	public Vehicle getVehicleById(String id) {
		return vehicleDAO.searchVehicle(id);
	}
	


}
