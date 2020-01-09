package com.mongo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongo.collections.User;
import com.mongo.repositories.UserRepository;

@Service
public class SetUserServiceImpl implements SetUserService {
	
	// Autowire the User Repository
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public User saveUser(User user) {
		return userRepo.save(user);
	}

}
