package com.mrinal.repo;


import org.springframework.data.repository.CrudRepository;

import com.mrinal.model.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	public User findByemailId(String emailId);
	
}
