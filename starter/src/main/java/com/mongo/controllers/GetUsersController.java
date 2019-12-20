package com.mongo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.model.User;
import com.mongo.services.GetUsersService;
import com.mongo.services.SetUserService;

@RestController
public class GetUsersController {
	
	// @Autowire the service
	@Autowired
	private GetUsersService getUserService;
	
	@Autowired
	private SetUserService setUserService;
	
	
	// Create the constructor
	
	
//	@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello world"; }
	
	@PostMapping(value = "/api/mongo/addUser")
	public void addUser(@RequestBody User user) {
		User savedUser = setUserService.saveUser(user);
	}
	
	
	// Create the @GetMapping request
//	@GetMapping("/api/mongo/getUsers")
//	public List<User> getUsers(@Valid @RequestBody GetUsersRequest request) {
//		
////		return new List<User>;
//	}
	
	

}
