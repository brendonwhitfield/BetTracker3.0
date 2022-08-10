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

//import com.qa.betTracker.domain.BetType;
import com.qa.betTracker.domain.Bets;
import com.qa.betTracker.repository.BetRepository;

@RestController
@RequestMapping("/Bets")
public class BetsController {

	private BetRepository betRepository;

	public BetsController(BetRepository betRepository) {
		super();
		this.betRepository = betRepository;
	}

	@GetMapping("/getAll")
	Collection<Bets> getAll() {
		return betRepository.findAll();
	}

	@GetMapping("/getBets/{id}")
	ResponseEntity<?> getBets(@PathVariable Long id) {
		Optional<Bets> bets = betRepository.findById(id);
		return bets.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/delete/{id}")
	ResponseEntity<?> deleteBets(@PathVariable Long id) {
		betRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/create")
	ResponseEntity<Bets> createBets(@Valid @RequestBody Bets bets) throws URISyntaxException {
		Bets result = betRepository.save(bets);
		return ResponseEntity.created(new URI("/Bets/bets" + result.getId())).body(result);
	}

	@PutMapping("/update/{id}")
	ResponseEntity<Bets> updateBets(@Valid @RequestBody Bets bets) {
		Bets result = betRepository.save(bets);
		return ResponseEntity.ok().body(result);
	}
}
