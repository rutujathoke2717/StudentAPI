package com.javasample.javademoproject.service;

import java.util.List;

import com.javasample.javademoproject.entity.Student;


public interface DemoService {
	
	public List<Student> listAll();
	
	public Student save(Student data);
	
	public Student get(Integer id);
	
	public String delete(Integer id);
	
	public Student update(Student data , Student Existingdata);
	
	public Student findByName(String name);

	public Student findById(int id);


	
	
	

}
