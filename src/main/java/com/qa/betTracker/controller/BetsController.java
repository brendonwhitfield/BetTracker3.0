package com.qa.betTracker.controller;

import java.util.Collection;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.betTracker.domain.Bets;
import com.qa.betTracker.service.BetService;

@Service
@RestController
@RequestMapping("/Bets")
public class BetsController {

	private BetService betService;

	public BetsController(BetService betService) {
		super();
		this.betService = betService;
	}

	@GetMapping("/getAll")
	Collection<Bets> getAll() {
		return this.betService.getAllBets();

	}

	@PutMapping("/deleteBets")
	boolean deleteBets(@PathParam("id") long id) {
		this.betService.deleteBets2(id);
		return false;
	}

	@PostMapping("/createBets")
	Bets createBets(@Valid @RequestBody Bets bets) {
		return this.betService.createBets2(bets);
	}

	@PutMapping("/updateBets")
	Bets updateBets(@PathParam("id") long id, @RequestBody Bets bets) {
		return this.betService.UpdateBets(id, bets);
	}

}
