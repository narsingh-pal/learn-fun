package com.nsp.j2ee.test.core.converters;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable{
	private static final long serialVersionUID = 4654327079994923358L;
	private String name;
	private int age;
	private String position;
	private double salary;
	private String [] skills;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String [] skills) {
		this.skills = skills;
	}
	
	public Employee() {
		super();
	}
	
	public Employee(String name, int age, String position, double salary, String[] skills) {
		super();
		this.name = name;
		this.age = age;
		this.position = position;
		this.salary = salary;
		this.skills = skills;
	}

	
	
	
	
}
