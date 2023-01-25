package com.javasample.javademoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javasample.javademoproject.entity.Student1;
import com.javasample.javademoproject.exception.StudentIsAlreadyExistedException;
import com.javasample.javademoproject.exception.StudentNotFoundException;
import com.javasample.javademoproject.service.DemoService;

@RestController
public class DemoController {

	@Autowired
	private DemoService demoservice;

	@GetMapping("/student")
	public List<Student1> listAll() {
		return demoservice.listAll();
	}

	@GetMapping("/school/{id}")
	public ResponseEntity<Student1> get(@PathVariable("id") int id) throws StudentNotFoundException {
		return new ResponseEntity<>(demoservice.get(id), HttpStatus.OK);

	}

	@PostMapping("/school")
	public ResponseEntity<Student1> save(@Validated @RequestBody Student1 std) {
		Student1 data = demoservice.findByName(std.getName());
		if (data != null) {
			throw new StudentIsAlreadyExistedException("Student is already existed");
		} else
			return new ResponseEntity<>(demoservice.save(std), HttpStatus.CREATED);
	}

	@PutMapping("/school/{id}")
	public ResponseEntity<Student1> update(@RequestBody Student1 std, @PathVariable("id") int id) {
		Student1 existingdata = demoservice.findById(id);
		if (existingdata == null) {
			throw new StudentNotFoundException("Student not found ");
		}
		return new ResponseEntity<>(demoservice.update(std, existingdata), HttpStatus.OK);
	}

	@DeleteMapping("/school/{id}")
	public ResponseEntity<Student1>delete(@PathVariable("id") int id){
		Student1 existingdata = demoservice.findById(id);
		if(existingdata==null) {
			throw new StudentNotFoundException("Student not found ");
		}
		return new ResponseEntity(demoservice.delete(id),HttpStatus.OK);
		
	}
}
