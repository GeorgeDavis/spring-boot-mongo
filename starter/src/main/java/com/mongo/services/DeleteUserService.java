package com.mongo.services;

import com.mongo.model.delete.DeleteUserRequest;
import com.mongo.model.delete.DeleteUserResponse;
import org.springframework.http.ResponseEntity;

public interface DeleteUserService {

    ResponseEntity<DeleteUserResponse> deleteUser(DeleteUserRequest request);

}