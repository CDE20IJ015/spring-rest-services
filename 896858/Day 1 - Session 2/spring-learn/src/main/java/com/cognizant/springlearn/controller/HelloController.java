package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//REST service that returns the text "Hello World!!" using Spring Web Framework.
@RestController
public class HelloController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("Start");
		LOGGER.info("End");
		return "Hello World!!";
	}
	
}

/*
Sample Request: http://localhost:8083/hello 
Sample Response: Hello World!!
*/