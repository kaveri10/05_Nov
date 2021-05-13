package com.spring.service;

import java.util.List;

import com.spring.exception.EmployeeNotFoundException;
import com.spring.json.Department;
import com.spring.json.Employee;

public interface EmployeeService {
	public Employee createEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public List<Department> getAllDepartments();
	public Employee getEmployeeById(long empId) throws EmployeeNotFoundException;
}
