package com.de.superchat.communication.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	
	@ExceptionHandler(value = {ObjectNotFilledException.class})
	public ResponseEntity<Object> handleObjectNotFilledException(ObjectNotFilledException e){
		HttpStatus notFound = HttpStatus.BAD_REQUEST;
		ApiException apiException = new ApiException(
				e.getMessage(),
                e, 
				notFound, 
				ZonedDateTime.now(ZoneId.of("Z"))
		);
		return new ResponseEntity<>(apiException, notFound);
	}
	
	@ExceptionHandler(value = {ObjectNotFoundException.class})
	public ResponseEntity<Object> handleObjectNotFoundException(ObjectNotFoundException e){
		HttpStatus notFound = HttpStatus.NOT_FOUND;
		ApiException apiException = new ApiException(
				e.getMessage(),
                e, 
				notFound, 
				ZonedDateTime.now(ZoneId.of("Z"))
		);
		return new ResponseEntity<>(apiException, notFound);
	}
	
	@ExceptionHandler(value = {ContactCreatedException.class})
	public ResponseEntity<Object> handleContactCreatedException(ContactCreatedException e){
		HttpStatus notFound = HttpStatus.NOT_ACCEPTABLE;
		ApiException apiException = new ApiException(
				e.getMessage(),
                e, 
				notFound, 
				ZonedDateTime.now(ZoneId.of("Z"))
		);
		return new ResponseEntity<>(apiException, notFound);
	}

}
