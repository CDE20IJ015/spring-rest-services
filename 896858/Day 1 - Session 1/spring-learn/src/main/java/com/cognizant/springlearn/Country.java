package com.cognizant.springlearn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);

//	Instance variables for code and name
	private String code;
	private String name;

//	Implement empty parameter constructor with inclusion of debug log with log message as “Inside Country Constructor.
	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}

//	Generate getters and setters with inclusion of debug with relevant message 
	public String getCode() {
		LOGGER.info("Start");

		LOGGER.info("End");
		return code;
	}

	public void setCode(String code) {
		LOGGER.info("Start");

		this.code = code;

		LOGGER.info("End");
	}

	public String getName() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return name;
	}

	public void setName(String name) {
		LOGGER.info("Start");

		this.name = name;

		LOGGER.info("End");
	}

//	Generate toString() method
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
