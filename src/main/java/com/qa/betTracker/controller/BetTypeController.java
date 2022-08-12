package com.qa.betTracker.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.betTracker.domain.BetType;
import com.qa.betTracker.repository.BetTypeRepository;

@RestController
@RequestMapping("/BetType")
public class BetTypeController {

	private BetTypeRepository betTypeRepository;

	public BetTypeController(BetTypeRepository betTypeRepository) {
		super();
		this.betTypeRepository = betTypeRepository;
	}

	@GetMapping("/getAll")
	Collection<BetType> getAll() {
		return betTypeRepository.findAll();
	}

	@GetMapping("/getBetType/{id}")
	ResponseEntity<?> getBetType(@PathVariable Long id) {
		Optional<BetType> betType = betTypeRepository.findById(id);
		return betType.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

	}

	@PostMapping("/create")
	ResponseEntity<BetType> createBetType(@RequestBody BetType betType) throws URISyntaxException {
		BetType result = betTypeRepository.save(betType);
		return ResponseEntity.created(new URI("/BetType/betType" + result.getId())).body(result);

	}

	@PutMapping("/update")
	ResponseEntity<BetType> updateBetType(@PathParam("id") @RequestBody BetType betType) {
		BetType result = betTypeRepository.save(betType);
		return ResponseEntity.ok().body(result);
	}

	@PutMapping("/deleteBetType")
	ResponseEntity<?> deleteBetType(@PathParam("id") @PathVariable Long id) {
		betTypeRepository.deleteById(id);
		return ResponseEntity.ok().build();
	}
}