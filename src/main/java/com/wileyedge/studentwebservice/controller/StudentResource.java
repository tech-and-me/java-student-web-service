package com.wileyedge.studentwebservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wileyedge.studentwebservice.exception.StudentNotFoundException;
import com.wileyedge.studentwebservice.model.Student;
import com.wileyedge.studentwebservice.service.IService;

@RestController
@CrossOrigin(origins = "*") 
public class StudentResource {
	
	@Autowired
	private IService service;
	
	@GetMapping(path = "/students")
	public List<Student> fetchAllStudents(){
		List<Student> users = service.retrieveAllUsers();
		return users;
	}
	
	
	@GetMapping(path = "/students/{id}")
	public Student fetchStudentById(@PathVariable int id) {
		Student student = null;
		student = service.retrieveOne(id);
		
		if(student == null) {
			throw new StudentNotFoundException("Student not found");
		}
		return student;
	}
	
	@GetMapping(path="/students/name/{name}")
	public List<Student> fetchStudentByName(@PathVariable String name) {
		List<Student> students = null;
		students = service.findByName(name);
		
		return students;
	}
	
	@PostMapping(path = "/students")
	public Student createStudent(@RequestBody Student student) {
		Student stu = service.save(student);
		return stu;
	}
	
	@DeleteMapping(path = "/students/{id}")
	public void deleteStudent(@PathVariable int id) {
		service.deleteOneStudent(id);
	}
	
	
	@PutMapping(path="/students")
	public Student updateStudent(@RequestBody Student student) {
		//send update student info to service layer
		Student existingStudent = service.updateStudent(student);
		Student updatedStudent = service.updateStudent(existingStudent);
				
		return updatedStudent;
	}
	
}
