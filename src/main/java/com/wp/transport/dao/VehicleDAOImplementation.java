package com.wp.transport.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
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
		String hql = "FROM Vehicle WHERE registrationNo=:registrationNoParam";
		Query qr = session.createQuery(hql);
		qr.setParameter("registrationNoParam", registrationNo);
		List<Vehicle> v = qr.list();
		//System.out.println(vehicle);
		tx.commit();
		session.close();
		return v.get(0);
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
	public List<String> getAllRegNo(int transportId){
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "SELECT registrationNo FROM Vehicle WHERE transporterId=:transportIdParam ";
		Query query = session.createQuery(hql);
		query.setParameter("transportIdParam", transportId);
		//query.setParameter("transportIdparam", transporterId);
		List<String> results = query.list();
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

	public List<Vehicle> getVehicleList() {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM Vehicle ";
		Query query = session.createQuery(hql);
		//query.setParameter("transportIdparam", transporterId);
		List results = query.list();
		session.close();
		return results;

	}

	public List<Vehicle> getUnapprovedVehicles(String propertyName, boolean value) {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();	
		/*Criteria cr = session.createCriteria(Vehicle.class);
		Criterion crt = Restrictions.eq("status", false);
		cr.add(crt);
		*/
		String hql = "FROM Vehicle WHERE Status=false";
		Query query = session.createQuery(hql);
		//query.setParameter("transportIdparam", transporterId);*/
		List results =query.list();
		session.close();
		return results;

	
	}

}
