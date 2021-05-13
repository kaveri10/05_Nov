package com.spring.cg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
// http://localhost:8080/cgapp/employee
@RestController
@RequestMapping("/cgapp")
public class EmployeeController {

	static List<Employee> empList = new ArrayList<Employee>();
	static {
		empList.add(new Employee(1, "Tom", 45000));
		empList.add(new Employee(2, "Jerry", 30000));
	}
	
/*
	@GetMapping(value="/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@RequestParam("id") String empId) {
		for(Employee emp: empList) {
			if(emp.id == Integer.parseInt(empId))
				return emp;
		}
		return null;
	}
*/	
	
	@GetMapping(value="/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("id") String empId, 
			@RequestHeader("auth-token") String authToken) {
		System.out.println("authToken = " + authToken);
		for(Employee emp: empList) {
			if(emp.id == Integer.parseInt(empId))
				return emp;
		}
		return null;
	}
	
	@GetMapping(value="/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		return empList;
	}
	
	@PostMapping(value="/employee", produces = MediaType.APPLICATION_JSON_VALUE, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public Employee createNewEmployee(@RequestBody Employee employee) {
		empList.add(employee);
		return employee;
	}
}












class Employee {
	public int id;
	public String name;
	public double salary;
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public Employee() {}
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}