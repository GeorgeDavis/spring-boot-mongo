package com.mongo.services;

import com.mongo.model.DeleteUserRequest;
import com.mongo.model.DeleteUserResponse;
import com.mongo.collections.User;
import com.mongo.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserServiceImpl implements DeleteUserService {

    @Autowired
    private UserRepository userRepository;

    public DeleteUserServiceImpl() {
        // empty constructor
    }

    @Override
    public ResponseEntity<DeleteUserResponse> deleteUser(DeleteUserRequest request) {

        DeleteUserResponse response = new DeleteUserResponse();
        User user = new User();
        user = userRepository.findUserByLastName(request.getLastName());
        userRepository.delete(user);
        return new ResponseEntity<DeleteUserResponse>(response, HttpStatus.OK);
    }

}