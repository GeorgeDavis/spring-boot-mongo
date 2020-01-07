package com.mongo.services;

import com.mongo.model.GetUsersRequest;
import com.mongo.model.GetUsersResponse;
import com.mongo.model.User;
import com.mongo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetUsersServiceImpl implements GetUsersService {
	
	// @Autowire the DAO / Mongo Custom Repository
	@Autowired
	private UserRepository userRepo;
	
	public ResponseEntity<GetUsersResponse> getUsers(GetUsersRequest request) {

		GetUsersResponse response = new GetUsersResponse();
		User user = userRepo.findFirstByGameName(request.getGameName());
		response.setFirstName(user.getFirstName());
		return new ResponseEntity<GetUsersResponse>(response, HttpStatus.OK);


	}

}
