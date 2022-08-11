package com.qa.betTracker.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.betTracker.domain.User;
import com.qa.betTracker.repository.UserRepository;

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
		return userRepository.findAll();
	}

	@GetMapping("/getUsers/{id}")
	ResponseEntity<?> getUser(@PathVariable Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> deleteBets(@PathVariable Long id) {
		userRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/create")
	ResponseEntity<User> createUser(@Valid @RequestBody User user) throws URISyntaxException {
		User result = userRepository.save(user);
		return ResponseEntity.created(new URI("/Users/users" + result.getId())).body(result);
	}

	@PutMapping("/update/{id}")
	ResponseEntity<User> updateUser(@Valid @RequestBody User user) {
		User result = userRepository.save(user);
		return ResponseEntity.ok().body(result);
	}
}
