package com.gammel.conan.scrabble.exceptions;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.gammel.conan.scrabble.ErrorResponse;

@ControllerAdvice
public class ScrabbleExceptionHandler {

	
	private static Logger logger = Logger.getLogger(ScrabbleExceptionHandler.class.getName());
	
	// Default 400 handling
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> httpMessageNotReadableHandler(
			final HttpMessageNotReadableException e, 
			final WebRequest request, 
			final HttpServletRequest httpServletRequest){
		
		logger.log(Level.INFO, "Throwing 400 with message: " + e.getMessage(), e);
		
		ErrorResponse response = new ErrorResponse();
		ErrorResponse.Error error = new ErrorResponse.Error();
		error.setCode(400);
		error.setMessage(e.getMessage());
		response.setErrors(Arrays.asList(error));
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<ErrorResponse>(response, headers, HttpStatus.BAD_REQUEST);
	}
	
	
	// Custom exception handling
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadGameParametersException.class)
	public @ResponseBody ResponseEntity<ErrorResponse> httpBadGameParameterRequest(
			final BadGameParametersException e, 
			final WebRequest request, 
			final HttpServletRequest httpServletRequest){
		
		ErrorResponse response = new ErrorResponse();
		response.setErrors(e.getErrors());
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<ErrorResponse>(response, headers, HttpStatus.BAD_REQUEST);
	}
}
