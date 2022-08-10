package com.qa.betTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.betTracker.domain.Bets;

@Repository
public interface BetRepository extends JpaRepository<Bets, Long> {

	Bets findByOutcome(String outcome);

	@Query(value = "SELECT * from Bets WHERE outcome = ?1 Limit 1", nativeQuery = true)
	Bets findBetsByOutcome(String outcome);

}