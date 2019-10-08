package com.wp.transport.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.transport.entities.Vehicle;
@Repository
public class VehicleDAOImplementation implements VehicleDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean addVehicle(Vehicle vehicle) {
		Session session = sessionFactory.openSession();
		Transaction transaction= session.beginTransaction();
		session.save(vehicle);
		transaction.commit();
		session.close();
		
		return true;
	}

	public Vehicle deleteVehicle(Vehicle vehicle) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vehicle searchVehicle(String registrationNo) {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		System.out.println("-------------------------------------------------------------@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		Vehicle vehicle = session.get(Vehicle.class, registrationNo);
		System.out.println(vehicle);
		tx.commit();
		session.close();
		return vehicle;
	}

	public List<Vehicle> getVehicleList(int transporterId) {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM Vehicle ";
		Query query = session.createQuery(hql);
		//query.setParameter("transportIdparam", transporterId);
		List results = query.list();
		session.close();
		return results;
		
	}

	public void updateVehicle(Vehicle vehicle) {
		Session session =  sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		session.update(vehicle);
		tx.commit();
		session.close();

	}

}
