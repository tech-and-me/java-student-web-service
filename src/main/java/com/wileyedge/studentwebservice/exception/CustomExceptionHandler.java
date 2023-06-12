package com.wileyedge.studentwebservice.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) { 
		ExceptionResponse exResponse = new ExceptionResponse(new Date(),ex.getMessage(),"details description of exption");
		return new ResponseEntity(exResponse , HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(StudentNotFoundException.class)
	public final ResponseEntity<Object> handleAllExceptions(StudentNotFoundException ex,WebRequest req) {
		ExceptionResponse exResponse = new ExceptionResponse(new Date(),ex.getMessage(),"Student with specified id/name is/are not in the records");
		return new ResponseEntity(exResponse , HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(StudentAlreadyExistedException.class)
    public final ResponseEntity<Object> handleStudentAlreadyExistedException(StudentAlreadyExistedException ex, WebRequest req) {
        ExceptionResponse exResponse = new ExceptionResponse(new Date(), ex.getMessage(), "Student with specified id already exists");
        return new ResponseEntity(exResponse, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(RequiredFieldsMissingException.class)
    public final ResponseEntity<Object> handleRequiredFieldsMissingException(RequiredFieldsMissingException ex, WebRequest req) {
        ExceptionResponse exResponse = new ExceptionResponse(new Date(), ex.getMessage(), "Required fields are missing.");
        return new ResponseEntity(exResponse, HttpStatus.BAD_REQUEST);
    }

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exResponse = new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().toString());

		return new ResponseEntity(exResponse , HttpStatus.BAD_REQUEST);
	}
	
	
}
