package com.mrinal.repo;

import org.springframework.data.repository.CrudRepository;

import com.mrinal.model.Sports;

public interface SportsRepo extends CrudRepository<Sports, Integer> {
	
	public Sports findBySportsName(String sportsName);

}
