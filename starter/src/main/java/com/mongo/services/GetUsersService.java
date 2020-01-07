package com.mongo.services;

import com.mongo.model.GetUsersRequest;
import com.mongo.model.GetUsersResponse;

import org.springframework.http.ResponseEntity;

//@FunctionalInterface
public interface GetUsersService {

    public ResponseEntity<GetUsersResponse> getUsers(GetUsersRequest request);
	
	

}


