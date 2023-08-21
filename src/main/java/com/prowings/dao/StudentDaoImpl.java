package com.prowings.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.prowings.entity.Student;
import com.prowings.entity.Subject;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	SessionFactory sessionFactory;
	
	
	@Override
	public List<Student> getStudents(){
		List<Student> listStd = null;
		try {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		Query<Student> query = session.createQuery("from Student");
		listStd = query.list();
		
		txn.commit();
		session.close();
		}
		
		catch (Exception e) {
			System.out.println("Eror occured while saving student...");
		}
		
		return listStd;
	}

	@Override
	public boolean saveStudent(Student std) {
		boolean result = false;
		try {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		session.save(std);
		txn.commit();
		session.close();
		result = true;
		}
		catch (Exception e) {
			System.out.println("Eror occured while saving student...");
		}
		
		return result;
	}

	@Override
	public Student getStudentById(int id) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Student retrievedStudent = session.get(Student.class, id);
		txn.commit();
		session.close();
		return retrievedStudent;
	}

	@Override
	public List<Subject> getSubjects() {
		List<Subject> listSub = null;
		try {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		
		Query<Subject> query = session.createQuery("from Subject");
		listSub = query.list();
		
		txn.commit();
		session.close();
		}
		
		catch (Exception e) {
			System.out.println("Eror occured while saving student...");
		}
		
		return listSub;

	}

	@Override
	public Subject getSubjectById(int id) {
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Subject retrievedSubject = session.get(Subject.class, id);
		txn.commit();
		session.close();
		return retrievedSubject;
	}

	@Override
	public List<Subject> getStudentByIdWithAllSubjects(int id) {
		List<Subject> list = null;
		
		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Student retrievedStudent = session.get(Student.class, id);
		txn.commit();
		session.close();
		return retrievedStudent.getSubject();
	}

	@Override
	public Subject getParticularSubjectOfParticularStudent(int id) {

		Session session = sessionFactory.openSession();
		Transaction txn = session.beginTransaction();
		Subject retrievedSubject = session.get(Subject.class, id);
		txn.commit();
		session.close();
		return retrievedSubject;
	}


}
