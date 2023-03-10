package com.springboot.crud.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.springboot.crud.entity.User;
import com.springboot.crud.repo.UserDao;

@Controller
public class LoginController {
	
	@Autowired
	UserDao userDao;
	
	CrudRestApi CrudRestApi;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		
		return "fancy-login";
		
	}
	
	// add request mapping for /access-denied
	
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		
		return "access-denied";
		
	}
	
	@PostMapping("/authenticateTheUser")
	
	public String authenticateTheUser(@RequestBody User credentials ) {
		
		String userName=credentials.getUserName();
		
		String password = credentials.getPassword();
		
		User user = userDao.findByUserName(userName);
		
		String passwordFromDb = user.getPassword();
		
		String passwordATM = passwordEncoder.encode(password);
		
		if(passwordEncoder.matches(password,passwordFromDb)) {
				return "redirect:/api/findAll";
		}
		else {
			return "oops" ;
		}
		
	}
	
}









