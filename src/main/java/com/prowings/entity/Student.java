package com.prowings.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import com.prowings.entity.Subject;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Student {

	@Id
	int id;

	@Column
	int roll;

	@Column
	String name;

	@Column
	@Autowired
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
	@JoinColumn(name = "subId")
	List<Subject> subject;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, int roll, String name, List<Subject> subject) {
		super();
		this.id = id;
		this.roll = roll;
		this.name = name;
		this.subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubject() {
		return subject;
	}

	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", roll=" + roll + ", name=" + name + ", subject=" + subject + "]";
	}

}
