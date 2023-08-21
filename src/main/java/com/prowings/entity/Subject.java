package com.prowings.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subject {
	
	@Id
	int id;
	
	@Column
	String subName;
	
	@Column
	String teacherName;

	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Subject(int id, String subName, String teacherName) {
		super();
		this.id = id;
		this.subName = subName;
		this.teacherName = teacherName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", subName=" + subName + ", teacherName=" + teacherName + "]";
	}

	
	
}
