package com.wileyedge.studentwebservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RequiredFieldsMissingException extends RuntimeException {
	public RequiredFieldsMissingException(String message) {
		super(message);
	}
}
