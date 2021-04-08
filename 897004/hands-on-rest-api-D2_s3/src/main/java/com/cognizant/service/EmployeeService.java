package com.cognizant.service;

import java.time.LocalDate;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.exception.EmployeeNotFoundException;
import com.cognizant.model.Department;
import com.cognizant.model.Employee;
import com.cognizant.model.Skill;
import com.cognizant.repo.DepartmentRepository;
import com.cognizant.repo.EmployeeRepository;
import com.cognizant.repo.SkillRepository;

@Service
public class EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired SkillRepository skillRepository;
	
	@PostConstruct
	public void addAllEmployee()
	{
		List<Department> d=departmentRepository.findAll();
		Employee e1=new Employee(1,"Abhishek Tiwari",23490.00,true,LocalDate.of(2000, 10, 10),d.get(0));
		Employee e2=new Employee(2,"Ayush Verma",25300.00,true,LocalDate.of(2000, 12, 15),d.get(1));
		Employee e3=new Employee(3,"Amit Makkad",21090.00,true,LocalDate.of(2200, 10, 20),d.get(0));
		Employee e4=new Employee(4,"Shivam Singh",26600.00,true,LocalDate.of(2030, 02, 10),d.get(1));
	    employeeRepository.save(e1);
	    employeeRepository.save(e2);
	    employeeRepository.save(e3);
	    employeeRepository.save(e4);
	}
	
	
	@Transactional
	public Employee get(int id) 
	{
	LOGGER.info("Start get method");
	return employeeRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Employee employee) 
	{
	LOGGER.info("Start save method");
	employeeRepository.save(employee);
	LOGGER.info("End save method");
	}
	
	@Transactional
	public List<Employee> getAllEmployee()
	{
		return employeeRepository.findAll();
	}


	public Employee addSkillToEmployee(int employeeId, int skillId) {
		Employee e=employeeRepository.getOne(employeeId);
		e.getSkillList().add(skillRepository.getOne(skillId));
		return employeeRepository.save(e);
	}
	
	public Employee updateEmployee(Employee employee)
	{
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(int id)
	{
		if(!employeeRepository.existsById(id))
		{
			throw new EmployeeNotFoundException("Employee with id "+id+" not exists");
		}
		employeeRepository.deleteById(id);
	}
}
