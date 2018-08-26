package com.gammel.conan.scrabble.exceptions;

import java.util.List;

import com.gammel.conan.scrabble.ErrorResponse;

public class BadGameParametersException extends Exception{

	private static final long serialVersionUID = 1L;
	
	
	private List<ErrorResponse.Error> errors;


	public List<ErrorResponse.Error> getErrors() {
		return errors;
	}


	public void setErrors(List<ErrorResponse.Error> errors) {
		this.errors = errors;
	}
	

}
