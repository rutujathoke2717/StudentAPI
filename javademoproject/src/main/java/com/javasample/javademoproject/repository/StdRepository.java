package com.javasample.javademoproject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javasample.javademoproject.entity.Student1;

@Repository
public interface StdRepository extends JpaRepository<Student1 , Integer> {

	Optional<Student1> findByName(String name);

}
