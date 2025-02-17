package com.example.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class Employee {
	private String name;
	private int age;
	private int salary;
	private String designation;
	private Address address;
	
	
	
	public Employee(String name, int age, int salary, String designation, Address address) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.designation = designation;
		this.address = address;
		System.out.println("From Employee Object");
	}
	
	public Employee() {

	}
	
	

	
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

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		System.out.println("Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", designation=" + designation + "]");
		System.out.println(address);
		return "";
	}
	
	

}
