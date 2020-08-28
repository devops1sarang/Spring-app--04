package com.example.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentPojo {
	@JsonProperty(value = "student-id")
	private String id;
	private String name;
	private String age;
	private String sname;

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

	@Override
	public String toString() {
		return "StudentPojo [id=" + id + ", name=" + name + "]";
	}

}
