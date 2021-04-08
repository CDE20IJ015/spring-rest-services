package com.cognizant.model;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "em_id")
	private int id;
	
	@Column(name = "em_name")
	@NotNull

	private String name;
	
	@NotNull
	@Column(name = "em_salary")
	private double salary;
	
	@NotNull
	@Column(name = "em_permanent")
	private boolean permanent;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
	@Column(name = "em_date_of_birth")
	private LocalDate dateOfBirth;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JsonManagedReference
	@JoinColumn(name = "em_dp_id")
	private Department department;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "employee_skill", joinColumns = @JoinColumn(name = "es_em_id"), inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
	private Set<Skill> skillList;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String name, double salary, boolean permanent, LocalDate dateOfBirth, Department department) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.permanent = permanent;
		this.dateOfBirth = dateOfBirth;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isPermanent() {
		return permanent;
	}

	public void setPermanent(boolean permanent) {
		this.permanent = permanent;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Set<Skill> getSkillList() {
		return skillList;
	}

	public void setSkillList(Set<Skill> skillList) {
		this.skillList = skillList;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", permanent=" + permanent
				+ ", dateOfBirth=" + dateOfBirth + ", departmentId=" + department.getId() + "skillList="
						+skillList+ "]\n";
	}


	
	
}

