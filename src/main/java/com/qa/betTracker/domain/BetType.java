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
@Table
public class BetType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(nullable = false, name = "sport")
	private String sport;

	/*
	 * @ManyToOne(cascade = CascadeType.PERSIST) private User user;
	 */

	/*
	 * calculator for each sport
	 * 
	 * @Column(nullable = false, name = "netProfit") private BigDecimal netProfit
	 */
}
