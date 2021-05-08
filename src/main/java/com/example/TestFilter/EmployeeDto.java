package com.example.TestFilter;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;


public class EmployeeDto {

	private String employeeName;
	private int salary;
	private int deptNo;

	public EmployeeDto(Employee emp) {
		this.employeeName = emp.getEmployeeName();
		this.salary = emp.getSalary();
		this.deptNo = emp.getDeptNo();
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
		return "EmployeeDto{" +
				"employeeName='" + employeeName + '\'' +
				", salary=" + salary +
				", deptNo=" + deptNo +
				'}';
	}
}
