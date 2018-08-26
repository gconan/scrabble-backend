package com.gammel.conan.scrabble;

import java.util.List;
import java.util.UUID;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Error Response", description = "Response when an error occurs")
public class ErrorResponse {
	
	@ApiModelProperty(value = "List of errors", required = true)
	private List<Error> errors;
	
	@ApiModelProperty(value = "ID to track the error", required = true)
	private UUID incidentId;
	
	public ErrorResponse() {
		this.incidentId = UUID.randomUUID();
	}

	
	public List<Error> getErrors() {
		return errors;
	}


	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}


	public UUID getIncidentId() {
		return incidentId;
	}


	public static class Error{
		@ApiModelProperty(value = "Unique integer code for the particular error", example = "001")
		private int code;
		
		@ApiModelProperty(value = "Error message", example = "The board size provided is too large. Board size must be between 15 and 100")
		private String message;
		
		public int getCode() {
			return code;
		}
		public void setCode(int code) {
			this.code = code;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
	}
}
