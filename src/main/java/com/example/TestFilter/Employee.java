package com.example.TestFilter;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@FilterDef(name = "salaryFilter", parameters = @ParamDef(name = "salary", type = "int"))
@FilterDef(name = "ageFilter", parameters = @ParamDef(name = "age", type = "int"))
@Filter(name = "salaryFilter", condition = "salary >:salary")
@Filter(name = "ageFilter", condition = "age <:age")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "salary")
	private int salary;

	@Column(name = "age")
	private int age;

	@ManyToOne
	@JoinColumn(name = "department_id", nullable = false)
	@Filter(name = "depFilter", condition = "id =:id")
	private Department department;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}
}
