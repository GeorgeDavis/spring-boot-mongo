package com.mongo.services;

import com.mongo.collections.User;
import com.mongo.model.CreateUserRequest;
import com.mongo.model.CreateUserResponse;
import com.mongo.model.common.StatusMessages;
import com.mongo.repositories.UserRepository;
import com.mongo.utility.BasicCommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SetUserServiceImpl implements SetUserService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public ResponseEntity<CreateUserResponse> saveUser(CreateUserRequest request) {

		CreateUserResponse response = new CreateUserResponse();
		userRepo.save(new User(request.getFirstName(), request.getLastName(), request.getStreetAddress(),
				request.getCity(), request.getState(), request.getGameName()));
		List<StatusMessages> statusMessagesList =  BasicCommonUtil.processStatusMessages("Success", "Data Updated", "User was saved.");
		response.setStatusMessages(statusMessagesList);
		return new ResponseEntity<>(response, HttpStatus.OK);

		//how do we know if the user was saved?
		//we attempt to save the new user. Is there already a user with the same id?
		//
	}

}
