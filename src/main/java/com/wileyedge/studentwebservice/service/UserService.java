package com.wileyedge.studentwebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wileyedge.studentwebservice.dao.IDao;
import com.wileyedge.studentwebservice.model.Student;

@Service
public class UserService implements IService {

	@Autowired
	@Qualifier("jparepos")
	private IDao dao;
	
	@Override
	public List<Student> retrieveAllUsers() {
		List<Student> students = dao.findAll();
		return students;
	}

	@Override
	public Student retrieveOne(int id) {
		Optional<Student> optStudent = dao.findById(id);
		Student student = null;
		if(optStudent.isPresent()) {
			student = optStudent.get();
		}
		
		return student;
	}

	@Override
	public Student save(Student student) {
		Student stu = dao.save(student);
		return stu;
	}

	@Override
	public void deleteOneStudent(int id) {
		dao.deleteById(id);		
	}
	
	@Override
	public List<Student> findByName(String name){
		List<Student> students = dao.findByName(name);
		
		return students;
		
	}

}
