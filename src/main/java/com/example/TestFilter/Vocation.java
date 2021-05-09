package com.example.TestFilter;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "vocation")
@FilterDef(name = "vocationFilter", parameters = @ParamDef(name = "name", type = "java.lang.String"))
@Filter(name = "vocationFilter", condition = "name =:name")
public class Vocation {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "vocation")
	private Set<Employee> employees;

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

}
