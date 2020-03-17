package com.wp.transport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.transport.dao.TransporterDAO;
import com.wp.transport.entities.Transporter;
@Service
public class TransporterServiceImpl implements  TransporterService {
	@Autowired
	TransporterDAO transporterDAO;
	public boolean addTransporter(Transporter transporter) {
		return transporterDAO.addTransporter(transporter);
	}

	public Transporter deleteTransporter(Transporter transporter) {
	 return transporterDAO.deleteTransporter(transporter);
	}

	public void updateTransporter(Transporter transporter) {
		transporterDAO.updateTransporter(transporter);	
	}

	public Transporter searchTransporter(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Transporter> show() {
		return transporterDAO.getTransporterList();
		
	}

	public Transporter getTransporter(String email, String password) {
		List<Transporter>data=transporterDAO.getTransporter(email,password);
		if(!data.isEmpty()) {
			return data.get(0);
		}
		return null;
		
	}

	
	public List<Transporter> getTransporterByStatus(boolean status) {
		List<Transporter> results =transporterDAO.getListByStatus(status);
		/*System.out.println("Ser-------------------------"+results.size());
		for(Transporter t: results) {
			System.out.println(t);
		}*/
		return results;
	}

	public Transporter getTransporterById(int id) {
		
		return  transporterDAO.getTransporterById(id);
	}
	
	

}
