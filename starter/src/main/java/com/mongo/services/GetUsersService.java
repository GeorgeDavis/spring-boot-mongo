package com.mongo.services;

import com.mongo.model.get.GetUsersRequest;
import com.mongo.model.get.GetUsersResponse;
import org.springframework.http.ResponseEntity;

//@FunctionalInterface
public interface GetUsersService {

    public ResponseEntity<GetUsersResponse> getUsers(GetUsersRequest request);
	
	

}


