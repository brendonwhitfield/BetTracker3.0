package com.qa.betTracker.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.betTracker.domain.User;
import com.qa.betTracker.repository.UserRepository;

@Service
@RestController
@RequestMapping("/Users")
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@GetMapping("/getAll")
	Collection<User> getAll() {
		return this.userRepository.findAll();
	}

	@GetMapping("/getUser/{id}")
	ResponseEntity<?> getUser(@PathVariable Long id) {
		Optional<User> user = this.userRepository.findById(id);
		return user.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/deleteUser")
	ResponseEntity<?> deleteUser(@PathParam("id") long id) {
		this.userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/createUser")
	ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
		User result = this.userRepository.save(user);
		return ResponseEntity.created(new URI("/Users/user" + result.getId())).body(result);
	}

	@PutMapping("/updateUsers")
	User updateUser(@PathParam("id") long id, @RequestBody User user) {
		return Update(id, user);
	}

	public User Update(long id, User user) {
		Optional<User> users = this.userRepository.findById(id);
		User updatedUser = users.get();
		updatedUser.setName(user.getName());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setAge(user.getAge());
		user = this.userRepository.save(updatedUser);
		return user;
	}
}