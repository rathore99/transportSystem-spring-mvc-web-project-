package com.wp.transport.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wp.transport.entities.Deal;

@Repository
public class DealDAOImpl implements  DealDAO{
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean addDeal(Deal deal) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		session.save(deal);
		
		tx.commit();
		session.close();
		
		return true;
	}

	public Deal deleteDeal(Deal Deal) {
		// TODO Auto-generated method stub
		return null;
	}

	public Deal searchDeal(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Deal> getDealList() {
		Session session =sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM Deal ";
		Query query = session.createQuery(hql);
		//query.setParameter("transportIdparam", transporterId);
		List results = query.list();
		session.close();
		return results;
	}

	public void updateDeal(Deal Deal) {
		// TODO Auto-generated method stub
		
	}

	public List<Deal> getDeal(String email, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
