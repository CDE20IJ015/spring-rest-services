package com.cognizant;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.model.Department;
import com.cognizant.model.Employee;
import com.cognizant.service.DepartmentService;
import com.cognizant.service.EmployeeService;
import com.cognizant.service.SkillService;

@SpringBootApplication
public class RestApiDay2Handson2Session2Application {
/*


	private static EmployeeService employeeService;
	//@Autowired
	private static DepartmentService departmentService;
	
	private static SkillService skillService;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RestApiDay2Handson2Session2Application.class);
	*/
	
	
	public static void main(String[] args) {
		
	SpringApplication.run(RestApiDay2Handson2Session2Application.class, args);
	}
}
