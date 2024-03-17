package com.blackpearl.nosql.mongodbdemo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Subject {

	@Field(name = "subject_name")
	private String subName;

	@Field(name = "marks_obtained")
	private Integer marksObtained;

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public Integer getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(Integer marksObtained) {
		this.marksObtained = marksObtained;
	}
}