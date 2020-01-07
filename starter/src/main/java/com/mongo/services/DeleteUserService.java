package com.mongo.services;

import com.mongo.model.DeleteUserRequest;
import com.mongo.model.DeleteUserResponse;

import org.springframework.http.ResponseEntity;

public interface DeleteUserService {

    ResponseEntity<DeleteUserResponse> deleteUser(DeleteUserRequest request);

}