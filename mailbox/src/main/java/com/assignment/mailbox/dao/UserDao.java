package com.assignment.mailbox.dao;



import org.springframework.data.repository.CrudRepository;

import com.assignment.mailbox.model.User;


public interface UserDao extends CrudRepository<User, Integer> {
	
	public User findByUsername(String username); 
		
	
}
