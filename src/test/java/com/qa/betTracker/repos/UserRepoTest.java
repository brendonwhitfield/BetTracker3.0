package com.qa.betTracker.repos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.betTracker.Application;
import com.qa.betTracker.domain.User;
import com.qa.betTracker.repository.UserRepository;

@SpringBootTest(classes = { Application.class })
@ActiveProfiles("test")
public class UserRepoTest {

	@Autowired
	private UserRepository repository;

	@BeforeEach
	public void dbWipe() {

	}

	@Test
	public void read() {

		Optional<User> expected = Optional.of(new User(1L, "Brendon Whitfield", "brendonwhitfield@email.com", 22));

		assertEquals(this.repository.findById((long) 1), expected);

	}

}