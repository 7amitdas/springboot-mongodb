package com.blackpearl.nosql.mongodbdemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "schools")
public class School {

	@Id
	private String id;

	@Field(name = "school_name")
	private String schoolName;

	@Field(name = "school_location")
	private String schoolLoc;

	@Field(name = "estd_on_year")
	private int estdOnYear;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolLoc() {
		return schoolLoc;
	}

	public void setSchoolLoc(String schoolLoc) {
		this.schoolLoc = schoolLoc;
	}

	public int getEstdOnYear() {
		return estdOnYear;
	}

	public void setEstdOnYear(int estdOnYear) {
		this.estdOnYear = estdOnYear;
	}
}