package com.wileyedge.studentwebservice.service;

import java.util.List;


import com.wileyedge.studentwebservice.model.Student;


public interface IService {
	public List<Student> retrieveAllUsers();

	Student retrieveOne(int id);

	public Student save(Student student);

	public void deleteOneStudent(int id);

	List<Student> findByName(String name);

	Student updateStudent(Student student);
}
