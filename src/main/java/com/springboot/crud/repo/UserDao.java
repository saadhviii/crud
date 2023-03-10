package com.springboot.crud.repo;

import com.springboot.crud.entity.User;

public interface UserDao {

    public User findByUserName(String userName);
    
    public void save(User user);
    
    public User returnUserByUsername(String userName);
    
}
