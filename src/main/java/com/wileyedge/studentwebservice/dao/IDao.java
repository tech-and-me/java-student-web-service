package com.wileyedge.studentwebservice.dao;

import java.util.List;
import java.util.Optional;

import com.wileyedge.studentwebservice.model.Student;

public interface IDao {
	public Student save(Student student);
	public List<Student> findAll();
	Optional<Student> findById(int id);
	public Student deleteById(int id);
	public List<Student> findByName(String name);
}
