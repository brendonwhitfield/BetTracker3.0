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

//import com.qa.betTracker.domain.BetType;
import com.qa.betTracker.domain.Bets;
import com.qa.betTracker.repository.BetRepository;

@Service
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
		return this.betRepository.findAll();
	}

	@GetMapping("/getBets/{id}")
	ResponseEntity<?> getBets(@PathVariable Long id) {
		Optional<Bets> bets = this.betRepository.findById(id);
		return bets.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PutMapping("/deleteBets")
	ResponseEntity<?> deleteBets(@PathParam("id") long id) {
		this.betRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/createBets")
	ResponseEntity<Bets> createBets(@Valid @RequestBody Bets bets) throws URISyntaxException {
		Bets result = this.betRepository.save(bets);
		return ResponseEntity.created(new URI("/Bets/bets" + result.getId())).body(result);
	}

	@PutMapping("/updateBets")
	Bets updateBets(@PathParam("id") long id, @RequestBody Bets bets) {
		return Update(id, bets);
	}

	public Bets Update(long id, Bets bets) {
		Optional<Bets> bet = this.betRepository.findById(id);
		Bets updatedBets = bet.get();
		updatedBets.setDescription(bets.getDescription());
		updatedBets.setOutcome(bets.getOutcome());
		updatedBets.setProfitLoss(bets.getProfitLoss());
		bets = this.betRepository.save(updatedBets);
		return bets;
	}
}
