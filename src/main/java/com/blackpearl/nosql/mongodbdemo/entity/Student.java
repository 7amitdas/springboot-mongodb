package com.blackpearl.nosql.mongodbdemo.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "students")
public class Student {

	@Id
	private String id;

	@Field(name = "name")
	private String name;

	@Field(name = "mail_id")
	private String email;

	@Field(name = "department")
	private Department dept;

	@Field(name = "subjects")
	private List<Subject> subjects;

	@DBRef
	private School school;

	@DBRef
	private List<Game> games;

	@Transient
	private double percentage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Department getDept() {
		return dept;
	}

	public void setDept(Department dept) {
		this.dept = dept;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public double getPercentage() {
		if (subjects != null && subjects.size() > 0) {
			int total = 0;
			for (Subject subject : subjects) {
				total = total + subject.getMarksObtained();
			}
			return total / subjects.size();
		}
		return 0;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
}