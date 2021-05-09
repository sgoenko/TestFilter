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

        session.enableFilter("vocationFilter")
                .setParameter("name", "manager");
        session.enableFilter("depFilter")
                .setParameter("name", "Constructions");
        session.enableFilter("salaryFilter")
                .setParameter("salary", 3000);
//        session.enableFilter("ageFilter")
//                .setParameter("age", 40);


//		select e.name, e.salary, e.age, d.name, v.name
//		from department d
//		join employee e on e.department_id=d.id
//		join vocation v on e.vocation_id=v.id
//		where e.salary> 3000 and e.age<40 and d.name='Constructions' and v.name='manager';

//		Mike	5000	25	Constructions	manager

//		String select = "select new com.example.TestFilter.EmployeeDto(e) from Department d join d.employees e";
//		String select = "select new com.example.TestFilter.EmployeeDto(e) from Department d join d.employees e join e.vocation v where v.name='manager'";
        String select;
//        select = "select new com.example.TestFilter.EmployeeDto(e) from Department d join d.employees e join e.vocation v";
//        select = "select new com.example.TestFilter.EmployeeDto(e) from Vocation v join v.employees e join e.department d";
//        select = "select new com.example.TestFilter.EmployeeDto(e) from Employee e join e.department d join e.vocation v";
        select = "select new com.example.TestFilter.EmployeeDto(e,d,v) "+
                "from Employee e, Department d, Vocation v "+
                "where e.department=d and e.vocation=v";

        List list = session.createQuery(select)
                .list();

        list.forEach(System.out::println);

        session.close();
    }
}

