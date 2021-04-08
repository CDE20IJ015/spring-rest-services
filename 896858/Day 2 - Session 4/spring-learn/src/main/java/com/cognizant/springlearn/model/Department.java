package com.cognizant.springlearn.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/* VALIDATIONS IN DEPARTMENT
 
id - should not be null, should be a number
name - should not be null, should not be blank, minimum 1 character and maximum 30 characters

*/

public class Department {

	@NotNull
	private int id;

	@NotNull
	@NotBlank
	@Size(min = 1, max = 30)
	private String name;

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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}

}
