package com.cognizant.springlearn.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//controller class for restful webservices
@RestController
public class HelloController {
	//incorporating logger
	Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

	//mapping the request
	@GetMapping("/hello")
	public String sayHello() {
		LOGGER.info("START");
		LOGGER.debug("Calling sayHello() with method 'GET'");
		LOGGER.info("END");
		return "Hello World!!";
	}
}