package com.wp.transport.dao;

import java.util.List;
import java.util.Map;

import com.wp.transport.entities.Customer;

public interface CustomerDAO {
	public boolean addCustomer(Customer customer);

	public Customer deleteCustomer(Customer customer);

	public Customer searchCustomer(String email );

	public List<Customer> getCustomerList();

	public void updateCustomer(Customer customer);
	
	public List<Customer> getCustomer(String email,String password);

}
