package com.springboot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.crud.entity.Customer;
import com.springboot.crud.repo.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService{

	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public List<Customer> findAll() {
		
		return customerRepo.findAll();
	}

	@Override
	public Customer findById(int id) {
		
		Customer theCustomer = customerRepo.findById(id).get();
		return theCustomer;
	}

	@Override
	public void save(Customer customer) {
		
		customerRepo.save(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerRepo.delete(customer);
		
	}
	
	@Override
	public Customer update(Customer customer) {
	
		Customer theCustomer = findById(customer.getId());
		theCustomer.setEmail(customer.getEmail());
		theCustomer.setFirstName(customer.getFirstName());
		theCustomer.setLastName(customer.getLastName());
		return theCustomer;
	}
	
	
	
}
