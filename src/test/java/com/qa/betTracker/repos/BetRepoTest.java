package com.qa.betTracker.repos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.qa.betTracker.Application;
import com.qa.betTracker.domain.Bets;
import com.qa.betTracker.repository.BetRepository;

@SpringBootTest(classes = { Application.class })
@ActiveProfiles("test")
public class BetRepoTest {

	@Autowired
	private BetRepository repository;

	@BeforeEach
	public void dbWipe() {

	}

	@Test
	public void read() {

		Optional<Bets> expected = Optional.of(new Bets(1L, "Single", "Win", 17.5));

		assertEquals(this.repository.findById((long) 1), expected);

	}

}