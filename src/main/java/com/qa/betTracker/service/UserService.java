package com.qa.betTracker.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.betTracker.domain.User;
import com.qa.betTracker.exceptions.UserNotFound;
import com.qa.betTracker.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Collection<User> getAllUsers() {
		return this.userRepository.findAll();
	}

	public boolean deleteUser2(long id) {
		if (this.userRepository.existsById(id) == false) {
			throw new UserNotFound();
		} else {
			this.userRepository.deleteById(id);
			boolean doesNotExist = this.userRepository.existsById(id);
			return doesNotExist;

		}
	}

	public User createUser2(User user) {
		User result = this.userRepository.save(user);
		return result;
	}

	public User UpdateUser2(long id, User user) {
		Optional<User> users = this.userRepository.findById(id);
		User updatedUser = users.get();
		updatedUser.setName(user.getName());
		updatedUser.setEmail(user.getEmail());
		updatedUser.setAge(user.getAge());
		user = this.userRepository.save(updatedUser);
		return user;
	}
}
