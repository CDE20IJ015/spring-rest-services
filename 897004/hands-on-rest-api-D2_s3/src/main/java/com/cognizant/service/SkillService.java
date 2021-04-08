package com.cognizant.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.model.Skill;
import com.cognizant.repo.SkillRepository;

@Service
public class SkillService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);
	
	@Autowired
	private SkillRepository skillRepository;
	
	@PostConstruct
	public void addAllSkills()
	{
	  Skill s1=new Skill(1,"C");	
	  Skill s2=new Skill(2,"C++");
	  Skill s3=new Skill(3,"Java");
	  Skill s4=new Skill(4,"Python");
	  Skill s5=new Skill(5,"C#");
	  skillRepository.save(s1);
	  skillRepository.save(s2);
	  skillRepository.save(s3);
	  skillRepository.save(s4);
	  skillRepository.save(s5);
	}
	
	
	@Transactional
	public Skill get(int id) 
	{
	LOGGER.info("Start get method");
	return skillRepository.findById(id).get();
	}
	
	@Transactional
	public void save(Skill skill) 
	{
	LOGGER.info("Start save method");
	skillRepository.save(skill);
	LOGGER.info("End save method");
	}
	
	public List<Skill> getAllSkill()
	{
		return skillRepository.findAll();
	}
}
