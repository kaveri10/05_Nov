package com.spring.util;

import java.util.ArrayList;
import java.util.List;

import com.spring.entity.DepartmentEntity;
import com.spring.entity.EmployeeEntity;
import com.spring.json.Department;
import com.spring.json.Employee;

public class EmployeeUtil {

	public static Employee convertEmployeeEntityIntoEmployee(EmployeeEntity employeeEntity) {
		Department department = new Department(employeeEntity.getDepartment().getDeptId(), employeeEntity.getDepartment().getName());
		Employee employee = 
				new Employee(employeeEntity.getEmployeeId(), employeeEntity.getName(), employeeEntity.getSal(), department);
		return employee;
	}

	public static EmployeeEntity convertEmployeeIntoEmployeeEntity(Employee employee, DepartmentEntity departmentEntity) {
		return new EmployeeEntity(employee.getName(), employee.getSal(), departmentEntity);
	}

	public static List<Employee> convertEmployeeEntityListIntoEmployeeList(List<EmployeeEntity> employeeEntityList) {
		List<Employee> employees = new ArrayList<Employee>();
		for(EmployeeEntity employeeEntity: employeeEntityList) {
			employees.add(convertEmployeeEntityIntoEmployee(employeeEntity));
		}
		return employees;
	}
}
