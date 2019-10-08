package com.wp.transport.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.transport.entities.User;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public void addUser(User user1) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(user1);
		tx.commit();
		session.close();	
	}
	public void show() {
		// TODO Auto-generated method stub
		
	}
	
}
