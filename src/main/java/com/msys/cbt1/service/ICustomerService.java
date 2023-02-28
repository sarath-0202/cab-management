package com.msys.cbt1.service;

import java.util.List;

import com.msys.cbt1.entities.Customer;

public interface ICustomerService {
	public Customer insertCustomer(Customer customer);

	public Customer updateCustomer(Customer customer);

	public Customer deleteCustomer(Customer customer);

	public List<Customer> viewCustomers();

	public Customer viewCustomer(int customerId);

	public Customer validateCustomer(String username, String password);
}