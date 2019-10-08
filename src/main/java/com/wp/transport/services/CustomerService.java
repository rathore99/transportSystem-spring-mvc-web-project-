package com.wp.transport.services;

import java.util.List;

import com.wp.transport.entities.Customer;

public interface CustomerService {
	public boolean addCustomer(Customer customer);

	public Customer deleteCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public Customer searchCustomer(int rollNo);

	public List<Customer> show();
	
	public boolean getCustomer(String email,String password);
}
