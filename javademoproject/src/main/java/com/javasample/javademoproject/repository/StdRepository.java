package com.javasample.javademoproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasample.javademoproject.entity.Student;

@Repository
public interface StdRepository extends JpaRepository<Student , Integer> {

	Optional<Student> findByName(String name);

}
