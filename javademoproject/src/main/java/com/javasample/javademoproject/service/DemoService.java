package com.javasample.javademoproject.service;

import java.util.List;

import com.javasample.javademoproject.entity.Student1;

public interface DemoService {
	
	public List<Student1> listAll();
	
	public Student1 save(Student1 data);
	
	public Student1 get(Integer id);
	
	public String delete(Integer id);
	
	public Student1 update(Student1 data , Student1 Existingdata);
	
	public Student1 findByName(String name);

	public Student1 findById(int id);


	
	
	

}
