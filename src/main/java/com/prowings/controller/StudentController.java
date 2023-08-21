package com.prowings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prowings.entity.Student;
import com.prowings.entity.Subject;
import com.prowings.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/students")
	public String saveStudent(@RequestBody Student std) {
		System.out.println("request received to create student  : " + std);

		if (studentService.saveStudent(std))
			return "student saved sucessfully!!!";

		else
			return "student not saved!!!";

	}
 
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentService.getStudents();
		
	}
	
	@GetMapping("/students/{id}")
	public Student getStudentById(@PathVariable int id) {
		Student retrievedStd = studentService.getStudentById(id);
		return retrievedStd;
	}
	
	@GetMapping("/subjects")
	public List<Subject> getSubjects() {
		return studentService.getSubjects();
		
	}
	
	@GetMapping("/subjects/{id}")
	public Subject getSubjectById(@PathVariable int id) {
		Subject retrievedSub = studentService.getSubjectById(id);
		return retrievedSub;
	}
	
	@GetMapping("/students/{id}/subjects")
	public List<Subject> getStudentByIdWithAllSubjects(@PathVariable("id") int id) {
		return studentService.getStudentByIdWithAllSubjects(id);
		 
	}
	
	@GetMapping("/students/{id}/subjects/{id}")
	public Subject getParticularSubjectOfParticularStudent(@PathVariable int id) {
		return studentService.getParticularSubjectOfParticularStudent(id);
		 
	}
	
	
	

}
