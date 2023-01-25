package com.javasample.javademoproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javasample.javademoproject.entity.Student1;
import com.javasample.javademoproject.exception.StudentIsAlreadyExistedException;
import com.javasample.javademoproject.exception.StudentNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
	

	
	 @ExceptionHandler(StudentNotFoundException.class)
	    public ResponseEntity<Student1> StudentNotFoundException( StudentNotFoundException exception) {
		 return new ResponseEntity("Student not Found with id",HttpStatus.NOT_FOUND);
	    }
	
	 @ExceptionHandler( StudentIsAlreadyExistedException.class)
	 public ResponseEntity<Student1>  StudentIsAlreadyExistedException( StudentIsAlreadyExistedException exception){
		 return new ResponseEntity("Student is already existed with name",HttpStatus.ALREADY_REPORTED);
	 }
	

}