package com.wp.transport.dao;

import java.util.List;

import com.wp.transport.entities.Deal;

public interface DealDAO {
	
	public boolean addDeal(Deal Deal);

	public Deal deleteDeal(Deal Deal);

	public Deal searchDeal(String email );

	public List<Deal> getDealList();

	public void updateDeal(Deal Deal);
	
	public List<Deal> getDeal(String email,String password);
}
