package com.qa.betTracker.controller;

import java.util.Collection;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.betTracker.domain.User;
import com.qa.betTracker.service.UserService;

@Service
@RestController
@RequestMapping("/Users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;

	}

	@GetMapping("/getAll")
	Collection<User> getAll() {
		return this.userService.getAllUsers();
	}

	@PutMapping("/deleteUser")
	boolean deleteUser(@PathParam("id") long id) {
		this.userService.deleteUser2(id);
		return false;
	}

	@PostMapping("/createUser")
	User createUser(@Valid @RequestBody User user) {
		return this.userService.createUser2(user);
	}

	@PutMapping("/updateUsers")
	User updateUser(@PathParam("id") long id, @RequestBody User user) {
		return this.userService.UpdateUser2(id, user);
	}

}