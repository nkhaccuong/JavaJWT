package com.example.EmployeeServiceRedis.entity;

import java.io.Serializable;

public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7022626964867078023L;
	private int id;
	private String fullName;
	private int age;
	
	
	public Employee() {
		super();
	}


	public Employee(int id, String fullName, int age) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
}
