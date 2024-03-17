package com.blackpearl.nosql.mongodbdemo.entity;

import org.springframework.data.mongodb.core.mapping.Field;

public class Department {

	@Field(name = "department_name")
	private String deptName;

	@Field(name = "location")
	private String location;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
}