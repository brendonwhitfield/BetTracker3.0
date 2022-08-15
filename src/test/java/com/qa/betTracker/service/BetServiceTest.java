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
import com.qa.betTracker.domain.Bets;
import com.qa.betTracker.repository.BetRepository;

@SpringBootTest(classes = Application.class)
@ActiveProfiles("test")

public class BetServiceTest {

	@Autowired
	BetService betService;

	@MockBean
	BetRepository betRepository;

	@Test
	public void testCreate() {

		Bets bets = new Bets(1L, "Brendon Whitfield", "me@email.com", 43);
		Mockito.when(this.betRepository.save(bets)).thenReturn(bets);
		assertEquals(this.betService.createBets2(bets), bets);
		Mockito.verify(this.betRepository, Mockito.times(1)).save(bets);

	}

	@Test
	public void testDelete() {
		Long id = 1L;
		Mockito.when(this.betRepository.existsById(id)).thenReturn(true, false);
		Mockito.when(this.betService.deleteBets2(id)).thenReturn(false);
		Mockito.verify(this.betRepository, Mockito.times(1)).existsById(id);
		Mockito.verify(this.betRepository, Mockito.times(1)).deleteById(id);
	}

	@Test
	public void testUpdate() {
		Bets bets = new Bets(1L, "Brendon Whitfield", "me@email.com", 43);
		Bets updateTest = new Bets(1L, "Brendon Whitfield", "me@email.com", 43);
		Optional<Bets> optional = Optional.of(bets);
		Long id = 1L;
		Mockito.when(betRepository.findById(id)).thenReturn(optional);
		Mockito.when(betRepository.save(updateTest)).thenReturn(updateTest);
		assertEquals(updateTest, betService.UpdateBets(id, updateTest));
		Mockito.verify(this.betRepository, Mockito.times(1)).findById(id);
		Mockito.verify(this.betRepository, Mockito.times(1)).save(updateTest);
	}

	@Test
	public void testGetAll() {
		Bets bets = new Bets(1L, "Brendon Whitfield", "me@email.com", 43);
		List<Bets> list = new ArrayList<Bets>();
		list.add(bets);

		Mockito.when(betRepository.findAll()).thenReturn(list);
		assertEquals(list, betService.getAllBets());
		Mockito.verify(this.betRepository, Mockito.times(1)).findAll();
	}

}
