package com.qa.betTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.betTracker.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

	@Query(value = "SELECT * from Users WHERE email = ?1 Limit 1", nativeQuery = true)
	User findUserByEmail(String email);

}