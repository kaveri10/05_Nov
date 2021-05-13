package com.spring.json;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Employee {

	@Min(value=1)
	private Long employeeId;
	
	@NotBlank
	@NotNull
	private String name;
	
	@Min(value=10000)
	@Max(value=100000)
	private double sal;
	private Department department;
	
	public Employee() {
		
	}
	
	public Employee(String name, double sal) {
		this.name = name;
		this.sal = sal;
	}

	public Employee(Long employeeId, String name, double sal) {
		this.employeeId = employeeId;
		this.name = name;
		this.sal = sal;
	}

	public Employee(Long employeeId, String name, double sal, Department department) {
		this.employeeId = employeeId;
		this.name = name;
		this.sal = sal;
		this.department = department;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String toString() {
		return employeeId + " - " + name + " - " + sal + " - " + department;
	}
	
}
