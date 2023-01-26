package com.javasample.javademoproject.serviceImpl;

import java.util.List;



import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javasample.javademoproject.entity.Student;
import com.javasample.javademoproject.exception.StudentNotFoundException;
import com.javasample.javademoproject.repository.StdRepository;
import com.javasample.javademoproject.service.DemoService;

@Service
@Transactional
public class DemoserviceImpl implements DemoService {

	@Autowired
	private StdRepository repository;

	@Override
	public List<Student> listAll() {
		return repository.findAll();
	}

	@Override
	public Student save(Student data) {
		return repository.save(data);
	}

	@Override
	public Student get(Integer id) throws StudentNotFoundException {
		Student std;
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
	public Student update(Student data, Student existingdata) {
		if (data.getName() != null) {
			existingdata.setName(data.getName());
		}
		if (data.getStd() != null) {
			existingdata.setStd(data.getStd());
		}
		return repository.save(existingdata);
	}

	public Student  findByName(String name) {
		Optional<Student> std = repository.findByName(name);
		if (std.isPresent()) {
			return std.get();
		}
		return null;
	}

	@Override
	public Student findById(int id) {
		Optional<Student> emp = repository.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
	}

}
