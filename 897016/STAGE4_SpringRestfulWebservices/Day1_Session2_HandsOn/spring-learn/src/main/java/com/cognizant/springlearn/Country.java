package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//pojo class
public class Country {

	private String code;
	private String name;

	public Country() {
		Logger LOGGER = LoggerFactory.getLogger(Country.class);
		LOGGER.debug("Inside the constructor");
	}

	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}

	//getters and setters
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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
		return "Country [code=" + code + ", name=" + name + "]";
	}

}