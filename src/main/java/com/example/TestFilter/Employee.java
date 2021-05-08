package com.example.TestFilter;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@FilterDef(name = "salaryFilter", parameters = @ParamDef(name = "salary", type = "int"))
@FilterDef(name = "depFilter", parameters = @ParamDef(name = "deptNo", type = "int"))
@Filter(name = "salaryFilter", condition = "salary >:salary")
@Filter(name = "depFilter", condition = "deptNo =:deptNo")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int employeeId;

	@Column(name = "ename")
	private String employeeName;

	@Column(name = "salary")
	private int salary;

	@Column(name = "deptno")
	private int deptNo;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeId=" + employeeId +
				", employeeName='" + employeeName + '\'' +
				", salary=" + salary +
				", deptNo=" + deptNo +
				'}';
	}
}
