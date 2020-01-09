package com.mongo.controllers;

import com.mongo.collections.User;
import com.mongo.model.DeleteUserRequest;
import com.mongo.model.DeleteUserResponse;
import com.mongo.model.GetUsersRequest;
import com.mongo.model.GetUsersResponse;
import com.mongo.services.DeleteUserService;
import com.mongo.services.GetUsersService;
import com.mongo.services.SetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class GetUsersController {

	private GetUsersService getUserService;

	private SetUserService setUserService;

	private DeleteUserService deleteUserService;

	@Autowired
	public GetUsersController(GetUsersService getUsersService, SetUserService setUserService,
			DeleteUserService deleteUserService) {
		this.getUserService = getUsersService;
		this.setUserService = setUserService;
		this.deleteUserService = deleteUserService;
	}

	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello world";
	}

	// add user
	@PostMapping(value = "/api/mongo/addUser")
	public void addUser(@RequestBody User user) {
		User savedUser = setUserService.saveUser(user);
	}

	// get users
	@GetMapping("/api/mongo/getUsers")
	public ResponseEntity<GetUsersResponse> getUsers(@Valid @RequestBody GetUsersRequest request) {

		return getUserService.getUsers(request);
	}

	// delete user
	@DeleteMapping("api/mongo/deleteUser")
	public ResponseEntity<DeleteUserResponse> deleteUser(@Valid @RequestBody DeleteUserRequest request) {

		return deleteUserService.deleteUser(request);
	}

}
