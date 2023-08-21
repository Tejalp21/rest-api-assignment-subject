package com.prowings.dao;

import java.util.List;
import com.prowings.entity.Student;
import com.prowings.entity.Subject;

public interface StudentDao {

	public boolean saveStudent(Student std);
	
	public List<Student> getStudents();
	
	public Student getStudentById(int id);
	
	public List<Subject> getSubjects();
	
	public Subject getSubjectById(int id);
	
	public List<Subject> getStudentByIdWithAllSubjects(int id);
	
	public Subject getParticularSubjectOfParticularStudent(int id);
}
