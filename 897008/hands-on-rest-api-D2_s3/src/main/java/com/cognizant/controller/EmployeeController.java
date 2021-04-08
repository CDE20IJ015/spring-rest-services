package com.cognizant.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.Employee;
import com.cognizant.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping()
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	@PostMapping("/{skillId}")
	public Employee addSkillToEmployee(@PathVariable("employeeId") int employeeId,@PathVariable("skillId") int skillId)
	{
		return employeeService.addSkillToEmployee(employeeId,skillId);
	}
	
	
	@PutMapping()
	public Employee updateEmployee(@RequestBody @Valid  Employee employee)
	{
		System.out.println("Controller*******************************");
		return employeeService.updateEmployee(employee);
	}
	
	@DeleteMapping("/{employeeId}")
	@ResponseStatus(code=HttpStatus.OK)
	public void removeEmployee(@PathVariable("employeeId") int employeeId)
	{
		employeeService.deleteEmployee(employeeId);
	}

	
}
