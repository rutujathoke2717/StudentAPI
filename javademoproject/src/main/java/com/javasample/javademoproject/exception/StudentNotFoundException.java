package com.javasample.javademoproject.exception;


public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException(String errorMessage) {
		super(errorMessage);
	}
	

	
}
