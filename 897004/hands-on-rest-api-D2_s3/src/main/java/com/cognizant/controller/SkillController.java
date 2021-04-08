package com.cognizant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.service.SkillService;
import com.cognizant.model.*;
@RestController
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@GetMapping("/skills")
	public List<Skill> getAllSkill()
	{
		return skillService.getAllSkill();
	}
	
	
}
