package com.qa.betTracker.exceptions;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Bet does not exist with that ID")
public class BetNotFound extends EntityNotFoundException {

	private static final long serialVersionUID = 1988648763292245254L;

}