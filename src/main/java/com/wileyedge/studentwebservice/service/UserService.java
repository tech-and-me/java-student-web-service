package com.wileyedge.studentwebservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wileyedge.studentwebservice.dao.IDao;
import com.wileyedge.studentwebservice.exception.StudentNotFoundException;
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
	public List<Student> findByName(String name){
		List<Student> students = dao.findByName(name);
		if(students == null || students.isEmpty()) {
			throw new StudentNotFoundException("Student named " + name + " does not exist.");
		}
		return students;
	}
	
	@Override
	public void deleteOneStudent(int id) {
		Optional<Student> existingStudentOptional = dao.findById(id);
		if(existingStudentOptional == null || existingStudentOptional.isEmpty()) {
			throw new StudentNotFoundException("Student with ID " + id + " does not exist.");
		}else {
			dao.deleteById(id);		
		}
	}
	
	@Override
	public Student updateStudent(Student student) {	
		Student existingStudent = null;
		
		// Check if the student exists
		Optional<Student> existingStudentOptional = dao.findById(student.getStuid());
		if (!existingStudentOptional.isPresent()) {
			throw new StudentNotFoundException("Student with ID " + student.getStuid() + " does not exist.");
		}else {
			existingStudent = existingStudentOptional.get();
		}
		
		//Update existing student
		existingStudent.setName(student.getName());
		existingStudent.setAge(student.getAge());
		existingStudent.setMob(student.getMob());
		existingStudent.setAddr(student.getAddr());
		
		//Save updated student info to db
		Student updatedStudent = dao.save(existingStudent);
		
		return updatedStudent;
	}

}
