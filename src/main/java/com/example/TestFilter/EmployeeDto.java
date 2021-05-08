package com.example.TestFilter;

public class EmployeeDto {

	private String employeeName;
	private int salary;
	private int age;
	private Department departmant;

	public EmployeeDto(Employee emp) {
		this.employeeName = emp.getName();
		this.salary = emp.getSalary();
		this.age = emp.getAge();
		this.departmant = emp.getDepartment();
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

	public Department getDepartmant() {
		return departmant;
	}

	public void setDepartmant(Department departmant) {
		this.departmant = departmant;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeDto{" +
				"employeeName='" + employeeName + '\'' +
				", salary=" + salary +
				", age=" + age +
				", departmant=" + departmant +
				'}';
	}
}
