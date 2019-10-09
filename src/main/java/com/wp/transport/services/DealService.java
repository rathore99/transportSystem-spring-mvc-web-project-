package com.wp.transport.services;

import java.util.List;

import com.wp.transport.entities.Deal;

public interface DealService {
	
	public boolean addDeal(Deal deal);

	public Deal deleteDeal(Deal deal);

	public void updateDeal(Deal deal);

	public Deal searchDeal(int rollNo);

	public List<Deal> show();
	
	public boolean getDeal();

}
