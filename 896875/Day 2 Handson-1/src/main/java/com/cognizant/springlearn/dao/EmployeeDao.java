package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Employee;

@Repository
public class EmployeeDao {

	private static List<Employee> EMPLOYEE_LIST = new ArrayList<>();

	public EmployeeDao() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("employee.xml");
		EMPLOYEE_LIST = applicationContext.getBean("employees", ArrayList.class);
	}

	public List<Employee> getAllEmployees() {
		return EmployeeDao.EMPLOYEE_LIST;
	}
}
