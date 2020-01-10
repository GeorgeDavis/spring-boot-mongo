package com.mongo.controllers;

import com.mongo.model.*;
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

	@PostMapping(value = "/api/mongo/createUser")
	public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request) {

		return setUserService.saveUser(request);
	}

	@PostMapping("/api/mongo/getUsers")
	public ResponseEntity<GetUsersResponse> getUsers(@Valid @RequestBody GetUsersRequest request) {

		return getUserService.getUsers(request);
	}

	@DeleteMapping("api/mongo/deleteUser")
	public ResponseEntity<DeleteUserResponse> deleteUser(@Valid @RequestBody DeleteUserRequest request) {

		return deleteUserService.deleteUser(request);
	}

}
