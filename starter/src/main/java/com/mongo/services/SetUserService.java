package com.mongo.services;

import com.mongo.model.CreateUserRequest;
import com.mongo.model.CreateUserResponse;
import org.springframework.http.ResponseEntity;

public interface SetUserService {
	
	 ResponseEntity<CreateUserResponse> saveUser(CreateUserRequest request);

}
