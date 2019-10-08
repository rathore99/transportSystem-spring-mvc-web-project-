package com.wp.transport.services;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
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
	
	


}
