package com.qa.betTracker.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

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
	private Long id;

	@Column(nullable = false, name = "firstName")
	private String firstName;

	@Column(nullable = false, name = "lastName")
	private String lastName;

	@Column(nullable = false, name = "email")
	private String email;

	@Column(nullable = false, name = "address")
	private String address;

	@Column(nullable = false, name = "dateOfBirth")
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date dateOfBirth;

	/*
	 * @OneToMany private Set<BetType> betType;
	 */

}