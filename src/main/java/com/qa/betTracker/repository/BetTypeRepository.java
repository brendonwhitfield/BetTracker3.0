package com.qa.betTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.betTracker.domain.BetType;

@Repository
public interface BetTypeRepository extends JpaRepository<BetType, Long> {

	BetType findBySport(String sport);

	@Query(value = "SELECT * from BetType WHERE sport = ?1 Limit 1", nativeQuery = true)
	BetType findBetTypeBySport(String sport);

}