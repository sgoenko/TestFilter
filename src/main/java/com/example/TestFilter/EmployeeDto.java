package com.example.TestFilter;

public class EmployeeDto {

    private String employeeName;
    private int salary;
    private int age;
    private String departmant;
    private String vocation;

    public EmployeeDto(Employee emp, Department dep, Vocation vocation) {
        this.employeeName = emp.getName();
        this.salary = emp.getSalary();
        this.age = emp.getAge();
        this.departmant = dep.getName();
        this.vocation = vocation.getName();
    }

    @Override
    public String toString() {
        return employeeName + " " + salary + " " + age + " " + departmant + " " + vocation;
    }

    public void print() {
        System.out.println(this);
    }
}
