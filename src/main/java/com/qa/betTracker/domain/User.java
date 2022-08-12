package com.qa.betTracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	@Column(nullable = false, name = "name")
	private String name;

	@Column(nullable = false, name = "email")
	private String email;

	@Column(nullable = false, name = "age")
	private long age;

	/*
	 * @OneToMany private Set<BetType> betType;
	 */

}