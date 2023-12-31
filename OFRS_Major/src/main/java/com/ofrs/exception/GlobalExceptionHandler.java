package com.ofrs.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(InputNotProvidedException.class)
	public ResponseEntity<String> handleInputNotProvidedException(InputNotProvidedException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidInputProvidedException.class)
	public ResponseEntity<String> handleInvalidInputProvidedException(InvalidInputProvidedException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RecordAlreadyPresentException.class)
	public ResponseEntity<String> handleRecordAlreadyPresentException(RecordAlreadyPresentException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RecordNotFoundException.class)
	public ResponseEntity<String> handleRecordNotFoundException(RecordNotFoundException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ScheduledFlightNotFoundException.class)
	public ResponseEntity<String> handleScheduledFlightNotFoundException(RecordNotFoundException exception)
	{
		return new ResponseEntity<String>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}
}
