package com.qa.betTracker.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.betTracker.domain.Bets;
import com.qa.betTracker.exceptions.BetNotFound;
import com.qa.betTracker.repository.BetRepository;

@Service
public class BetService {

	@Autowired
	private BetRepository betRepository;

	public Collection<Bets> getAllBets() {
		return this.betRepository.findAll();
	}

	public boolean deleteBets2(long id) {
		if (this.betRepository.existsById(id) == false) {
			throw new BetNotFound();
		} else {
			this.betRepository.deleteById(id);
			boolean doesNotExist = this.betRepository.existsById(id);
			return doesNotExist;

		}

	}

	public Bets createBets2(Bets bets) {
		Bets result = this.betRepository.save(bets);
		return result;
	}

	public Bets UpdateBets(long id, Bets bets) {
		Optional<Bets> bet = this.betRepository.findById(id);
		Bets updatedBets = bet.get();
		updatedBets.setDescription(bets.getDescription());
		updatedBets.setOutcome(bets.getOutcome());
		updatedBets.setProfitLoss(bets.getProfitLoss());
		bets = this.betRepository.save(updatedBets);
		return bets;
	}
}
