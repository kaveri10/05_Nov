package com.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.EmployeeNotFoundException;
import com.spring.json.Department;
import com.spring.json.Employee;
import com.spring.service.EmployeeService;

@RestController
@CrossOrigin("*")
@RequestMapping("/myapp")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value="/employee", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping(value="/employee/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable("id") String empId) 
			throws EmployeeNotFoundException {
		return employeeService.getEmployeeById(Long.parseLong(empId));
	}
	
	@GetMapping(value="/department", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Department> getAllDepartments() {
		return employeeService.getAllDepartments();
	}
	
	@PostMapping(value="/employee", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> createNewEmployee(@Valid @RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.createEmployee(employee), HttpStatus.OK);
	}
/*	
	@ExceptionHandler(value=MethodArgumentTypeMismatchException.class)
	public String handleMethodArgumentTypeMismatchException()
*/	
}
