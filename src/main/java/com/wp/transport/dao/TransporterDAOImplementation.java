package com.wp.transport.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.transport.entities.Customer;
import com.wp.transport.entities.Transporter;
@Repository
public class TransporterDAOImplementation implements TransporterDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addTransporter(Transporter transporter) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(transporter);
		transaction.commit();
		session.close();
		
		return true;
	}

	public Transporter deleteTransporter(Transporter transporter) {
		// TODO Auto-generated method stub
		return null;
	}

	public Transporter searchTransporter(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Transporter> getTransporterList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateTransporter(Transporter transporter) {
		Session session =  sessionFactory.openSession();
		Transaction tx =session.beginTransaction();
		session.update(transporter);
		tx.commit();
		session.close();

	}

	public List<Transporter> getTransporter(String email, String password) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Transporter t WHERE t.email =:emailParam and t.password = :passwordParam";
		Query query = session.createQuery(hql);
		query.setParameter("emailParam", email);
		query.setParameter("passwordParam", password);
		List results = query.list();
		session.close();
		return results;
	}


}
