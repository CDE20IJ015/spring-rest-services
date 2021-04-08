package com.cognizant.springlearn.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Department {
	//validations for id
	@NotNull
	private int id;

	//validations for name
	@NotNull
	@NotBlank
	@Size(min = 1, max = 30)
	private String name;

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//overriding toString() method
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
