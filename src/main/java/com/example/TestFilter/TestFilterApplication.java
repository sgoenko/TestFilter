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
		LOG.info("STARTING THE APPLICATION");
		SpringApplication.run(TestFilterApplication.class, args);
		LOG.info("APPLICATION FINISHED");
	}

	@Override
	public void run(String... args) {
		LOG.info("EXECUTING : command line runner");

		Session session = sessionFactory.openSession();

		session.enableFilter("salaryFilter")
				.setParameter("salary", 4000);
		session.enableFilter("depFilter")
				.setParameter("deptNo", 1);

		List list = session.createQuery("select new com.example.TestFilter.EmployeeDto(e) from Employee e")
				.list();

		list.forEach(e-> System.out.println(e));

		session.close();
	}
}

