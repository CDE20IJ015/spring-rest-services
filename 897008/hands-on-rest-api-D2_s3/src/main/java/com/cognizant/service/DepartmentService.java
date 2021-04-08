package com.cognizant.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.model.Department;
import com.cognizant.repo.DepartmentRepository;

@Service
public class DepartmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@PostConstruct
	public void addDepartment()
	{
		Department d1=new Department(1,"CSE");
		Department d2=new Department(2,"EX");
		departmentRepository.save(d1);
		departmentRepository.save(d2);
	}
	
	@Transactional
	public Department get(int id) 
	{
	LOGGER.info("Start get method");
	return departmentRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Department department) 
	{
	LOGGER.info("Start save method");
	departmentRepository.save(department);
	LOGGER.info("End save method");
	}
	
	public List<Department> getAllDepartment()
	{
		return departmentRepository.findAll();
	}
}
