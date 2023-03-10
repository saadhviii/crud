package com.springboot.crud.service;


import org.springframework.security.core.userdetails.UserDetailsService;

import com.springboot.crud.entity.User;
import com.springboot.crud.user.CrmUser;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	public void save(CrmUser crmUser);
}
