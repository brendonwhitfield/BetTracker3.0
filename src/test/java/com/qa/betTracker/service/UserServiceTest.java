package com.qa.betTracker.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.betTracker.Application;
import com.qa.betTracker.domain.User;
import com.qa.betTracker.repository.UserRepository;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")

public class UserServiceTest {

	@Autowired
	UserService userService;

	@MockBean
	UserRepository userRepository;

	@Test
	public void testCreate() {

		User user = new User(1L, "Brendon Whitfield", "me@email.com", 43);
		Mockito.when(this.userRepository.save(user)).thenReturn(user);
		assertEquals(this.userService.createUser2(user), user);
		Mockito.verify(this.userRepository, Mockito.times(1)).save(user);

	}

	@Test
	public void testDelete() {
		Long id = 1L;
		Mockito.when(this.userRepository.existsById(id)).thenReturn(true, false);
		Mockito.when(this.userService.deleteUser2(id)).thenReturn(false);
		Mockito.verify(this.userRepository, Mockito.times(1)).existsById(id);
		Mockito.verify(this.userRepository, Mockito.times(1)).deleteById(id);
	}

	@Test
	public void testUpdate() {
		User user = new User(1L, "Brendon Whitfield", "me@email.com", 43);
		User updateTest = new User(1L, "Brendon Whitfield", "me@email.com", 43);
		Optional<User> optional = Optional.of(user);
		Long id = 1L;
		Mockito.when(userRepository.findById(id)).thenReturn(optional);
		Mockito.when(userRepository.save(updateTest)).thenReturn(updateTest);
		assertEquals(updateTest, userService.UpdateUser2(id, updateTest));
		Mockito.verify(this.userRepository, Mockito.times(1)).findById(id);
		Mockito.verify(this.userRepository, Mockito.times(1)).save(updateTest);
	}

	@Test
	public void testGetAll() {
		User user = new User(1L, "Brendon Whitfield", "me@email.com", 43);
		List<User> list = new ArrayList<User>();
		list.add(user);

		Mockito.when(userRepository.findAll()).thenReturn(list);
		assertEquals(list, userService.getAllUsers());
		Mockito.verify(this.userRepository, Mockito.times(1)).findAll();
	}

}
