package com.example.TestFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TestFilterApplication
		implements CommandLineRunner {
	@Autowired
	private SessionFactory sessionFactory;

	private static Logger LOG = LoggerFactory
			.getLogger(TestFilterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TestFilterApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Session session = sessionFactory.openSession();

		session.enableFilter("salaryFilter")
				.setParameter("salary", 4000);
		session.enableFilter("depFilter")
				.setParameter("name", "Sales");
//		session.enableFilter("ageFilter")
//				.setParameter("age", 35);

//		select e.name, e.salary, e.age, d.name from employee e join department d on e.department_id=d.id where e.salary> 4000 and d.name='Sales';
//		select e.name, e.salary, e.age, d.name from department d join employee e on e.department_id=d.id where e.salary> 4000 and d.name='Sales';
//		select e.name, e.salary, e.age, d.name from department d, employee e where  e.department_id=d.id and e.salary> 4000 and d.name='Sales'
//		Nick	5000	20	Sales
//		Mike	6000	30	Sales

//		String select = "select new com.example.TestFilter.EmployeeDto(e) from Employee e left join e.department d";
		String select = "select new com.example.TestFilter.EmployeeDto(e) from Department d left join d.employees e";
		List list = session.createQuery(select)
				.list();

		list.forEach(System.out::println);

		session.close();
	}
}

