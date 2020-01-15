package com.mongo.services;

import com.mongo.model.set.SetUserRequest;
import com.mongo.model.set.SetUserResponse;
import org.springframework.http.ResponseEntity;

public interface SetUserService {
	
	 ResponseEntity<SetUserResponse> saveUser(SetUserRequest request);

}
