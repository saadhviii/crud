package com.springboot.crud.service;

import java.util.List;

import com.springboot.crud.entity.Customer;

public interface CustomerService {

	
	public List<Customer> findAll();
	
	public Customer findById(int id);
	
	public void save(Customer customer);
	
	public void delete(Customer customer);
	
	public Customer update(Customer customer);
	
	
}
