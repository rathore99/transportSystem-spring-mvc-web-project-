package com.wp.transport.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wp.transport.dao.CustomerDAO;
import com.wp.transport.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerDAO customerDAO;

	public boolean addCustomer(Customer customer) {
		System.out.println("in service "+customer);
		return customerDAO.addCustomer(customer);
		
	}

	public Customer deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub

	}

	public Customer searchCustomer(int rollNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Customer> show() {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean getCustomer(String email,String password) {
		
		List<Customer>data= customerDAO.getCustomer(email,password);
		if(!data.isEmpty()) {
			return true;
		}
		return false;
	}

}
