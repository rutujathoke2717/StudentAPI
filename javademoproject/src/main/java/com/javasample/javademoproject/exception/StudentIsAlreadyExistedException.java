package com.javasample.javademoproject.exception;

public class StudentIsAlreadyExistedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentIsAlreadyExistedException(String errorMessage) {
		super(errorMessage);
		
	}

}
