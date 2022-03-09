package com.in28minutes.rest.webservices.restfulwebservices.emp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Component;

@Entity
@NamedQuery(name = "find_all_emp", query = "select p from Employee p")
@Component
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String desc;

	public Employee() {

	}

	public Employee(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", desc=" + desc + "]";
	}

	
}
