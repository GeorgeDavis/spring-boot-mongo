package com.mongo.services;

import com.mongo.collections.User;
import com.mongo.model.GetUsersRequest;
import com.mongo.model.GetUsersResponse;
import com.mongo.model.UserResponse;
import com.mongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetUsersServiceImpl implements GetUsersService {

	@Autowired
	private UserRepository userRepo;
	
	public ResponseEntity<GetUsersResponse> getUsers(GetUsersRequest request) {

		GetUsersResponse response = new GetUsersResponse();
		List<User> userList = userRepo.getUsersByGameName(request.getGameName());
		List<UserResponse> userResponseList = new ArrayList<UserResponse>();
		userResponseList = userList.stream().map(user -> new UserResponse(user.getFirstName(), user.getLastName(), user.getAddress(), user.getCity(), user.getState(), user.getGameName()))
				.collect(Collectors.toList());
		response.setGameNameUsersList(userResponseList);
		return new ResponseEntity<GetUsersResponse>(response, HttpStatus.OK);
	}

}
