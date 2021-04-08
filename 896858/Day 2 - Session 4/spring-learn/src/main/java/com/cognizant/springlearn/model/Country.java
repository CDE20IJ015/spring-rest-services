package com.cognizant.springlearn.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Validated and ensured that it does not exceed more than 2 characters 
public class Country {

	private static final Logger LOGGER = LoggerFactory.getLogger(Country.class);
	
	@NotNull //	@NotNull ensure that code is not null. 
	@Size(min = 2, max = 2, message = "Country code should be 2 characters") //@Size ensure that the width is exactly 2 characters.
	private String code;
	private String name;

	public Country() {
		LOGGER.debug("Inside Country Constructor");
	}

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

	@Override
	public String toString() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
