package com.springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.crud.entity.Customer;
import com.springboot.crud.service.CustomerService;

@Controller

@RequestMapping("/api")
public class CrudRestApi {
	
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping("/start")
	public String upAndRunning() {
		return "hello.html";
	}
	
	@PostMapping(path = "/save") 
	public String save(Customer customer) {
		customerService.save(customer);
		return "redirect:findAll";
	}
	
	@PutMapping("/update")
	public Customer update(@RequestBody Customer customer) {
		
		Customer theCustomer = customerService.update(customer);
		return theCustomer;
	}
	
	@GetMapping("/findById/{id}")
	public Customer findById(@PathVariable int id) {
		Customer theCustomer = customerService.findById(id);
		return theCustomer;
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		Customer customer = customerService.findById(id);
		customerService.delete(customer);
		return "redirect:findAll";
	}
	
	@GetMapping("/findAll")
	public String findAll(Model theModel) {
		List<Customer> theEmployees = customerService.findAll();
		theModel.addAttribute("employees",theEmployees);
		return "list-employees.html";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
		
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {
		Customer customer = new Customer();
		customer = customerService.findById(id);
		theModel.addAttribute("customer", customer);
		return "customer-form";
		
	}
	
	@DeleteMapping("/showFormForDelete")
	public String showFormForDelete(Customer customer) {
		customerService.delete(customer);
		return "list-employees";
	}
	
}
