package com.wp.transport.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.transport.entities.Customer;

@Repository
public class CustomerDAOImplementation implements CustomerDAO {

	@Autowired
	SessionFactory sessionFactory;


	/*private Session session() {
		return sessionFactory.openSession();
	}
	private Transaction transaction() {
		return session().beginTransaction();
	}
/*
	/*
	 * private Session session() { Session session = sessionFactory.openSession(); }
	 */
	public boolean addCustomer(Customer customer) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		session.close();
		return true;
	}

	public Customer deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer searchCustomer(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> getCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public List<Customer> getCustomer(String email, String password) {
		Session session = sessionFactory.openSession();
		String hql = "FROM Customer c WHERE c.email =:emailParam and c.password = :passwordParam";
		Query query = session.createQuery(hql);
		query.setParameter("emailParam", email);
		query.setParameter("passwordParam", password);
		List results = query.list();
		 
		
		return results;
	}

}
