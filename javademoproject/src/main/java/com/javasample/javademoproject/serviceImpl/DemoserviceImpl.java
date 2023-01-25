package com.javasample.javademoproject.serviceImpl;

import java.util.List;


import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javasample.javademoproject.entity.Student1;
import com.javasample.javademoproject.exception.StudentNotFoundException;
import com.javasample.javademoproject.repository.StdRepository;
import com.javasample.javademoproject.service.DemoService;

@Service
@Transactional
public class DemoserviceImpl implements DemoService {

	@Autowired
	private StdRepository repository;

	@Override
	public List<Student1> listAll() {
		return repository.findAll();
	}

	@Override
	public Student1 save(Student1 data) {
		return repository.save(data);
	}

	@Override
	public Student1 get(Integer id) throws StudentNotFoundException {
		Student1 std;
		if (repository.findById(id).isEmpty()) {
			throw new StudentNotFoundException("Student not found with id");
		} else
			std = repository.findById(id).get();
		return std;
	}

	@Override
	public String delete(Integer id) {
		repository.deleteById(id);
		return "Student Deleted";
	}

	@Override
	public Student1 update(Student1 data, Student1 existingdata) {
		if (data.getName() != null) {
			existingdata.setName(data.getName());
		}
		if (data.getStd() != null) {
			existingdata.setStd(data.getStd());
		}
		return repository.save(existingdata);
	}

	public Student1 findByName(String name) {
		Optional<Student1> std = repository.findByName(name);
		if (std.isPresent()) {
			return std.get();
		}
		return null;
	}

	@Override
	public Student1 findById(int id) {
		Optional<Student1> emp = repository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
	}

}
