package com.qa.betTracker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Bets")
public class Bets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false, name = "description")
	private String description;

	@Column(nullable = false, name = "outcome")
	private String outcome;

	@Column(nullable = false, name = "profitLoss")
	private double profitLoss;

	@JsonIgnore
	@ManyToOne
	private BetType betType;

	@JsonIgnore
	@ManyToOne
	private User users;

}