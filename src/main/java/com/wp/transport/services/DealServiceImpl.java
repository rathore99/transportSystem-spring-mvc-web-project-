package com.wp.transport.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.transport.dao.DealDAO;
import com.wp.transport.entities.Deal;

@Service
public class DealServiceImpl  implements DealService{

	@Autowired
	DealDAO dealdao;
	public boolean addDeal(Deal deal) {
		
		return dealdao.addDeal(deal);
	}

	public Deal deleteDeal(Deal deal) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateDeal(Deal deal) {
		// TODO Auto-generated method stub
		
	}

	public Deal searchDeal(int rollNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Deal> show() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean getDeal() {
		// TODO Auto-generated method stub
		return false;
	}
	

}
