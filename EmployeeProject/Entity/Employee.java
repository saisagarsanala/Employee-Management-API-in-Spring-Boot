package com.Forage.EmployeeProject.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Employee{
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Employee_id; 
	private String firstName; 
	private String lastName;
	private String email;
	private String title;
	
	public Employee(Integer employee_id, String firstName, String lastName, String email, String title) {
		
		this.Employee_id = employee_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Employee [Employee_id=" + Employee_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", title=" + title + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getEmployee_id() {
		return Employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		Employee_id = employee_id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
} 
