package com.springboot.crud.repo;

import com.springboot.crud.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
