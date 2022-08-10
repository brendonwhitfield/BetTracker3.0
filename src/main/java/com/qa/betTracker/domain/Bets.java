package com.qa.betTracker.domain;

import java.math.BigDecimal;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@Column(nullable = false, name = "stake")
	private BigDecimal stake;

	@Column(nullable = false, name = "odds")
	private BigDecimal odds;

	@Column(nullable = false, name = "profitLoss")
	private BigDecimal profitLoss;

	@Column(nullable = false, name = "betDate")
	private Instant betDate;

	@ManyToOne
	private BetType betType;

	@ManyToOne
	private User users;

}