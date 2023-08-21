package com.prowings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowings.dao.StudentDao;
import com.prowings.entity.Student;
import com.prowings.entity.Subject;

@Service
public class StudentServiceImpl implements StudentService  {

	@Autowired
	StudentDao studentDao;

	@Override
	public boolean saveStudent(Student std) {
		return studentDao.saveStudent(std);
	}

	@Override
	public List<Student> getStudents() {
		return studentDao.getStudents();
	}

	@Override
	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	@Override
	public List<Subject> getSubjects() {
		return studentDao.getSubjects();	}

	@Override
	public Subject getSubjectById(int id) {
		return studentDao.getSubjectById(id);
	}

	@Override
	public List<Subject> getStudentByIdWithAllSubjects(int id) {
		return studentDao.getStudentByIdWithAllSubjects(id);
	}

	@Override
	public Subject getParticularSubjectOfParticularStudent(int id) {
		return studentDao.getParticularSubjectOfParticularStudent(id);
	}
}
