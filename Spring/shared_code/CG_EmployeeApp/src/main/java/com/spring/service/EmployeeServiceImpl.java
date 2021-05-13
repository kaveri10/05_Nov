package com.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.entity.DepartmentEntity;
import com.spring.entity.EmployeeEntity;
import com.spring.exception.EmployeeNotFoundException;
import com.spring.json.Department;
import com.spring.json.Employee;
import com.spring.repo.DepartmentRepo;
import com.spring.repo.EmployeeRepo;
import com.spring.util.EmployeeUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private DepartmentRepo departmentRepo;
	
	@Override
	public Employee createEmployee(Employee employee) {
		Optional<DepartmentEntity> departmentOptional = departmentRepo.findById(employee.getDepartment().getDeptId());
		if(departmentOptional.isPresent()) {
			DepartmentEntity departmentEntity = departmentOptional.get();
			EmployeeEntity employeeEntity = 
			employeeRepo.save(EmployeeUtil.convertEmployeeIntoEmployeeEntity(employee, departmentEntity));
			return EmployeeUtil.convertEmployeeEntityIntoEmployee(employeeEntity);
		}
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<EmployeeEntity> employeeEntityList = employeeRepo.findAll();
		List<Employee> employees = new ArrayList<Employee>();
		for(EmployeeEntity employeeEntity: employeeEntityList) {
			Department department = new Department(employeeEntity.getDepartment().getDeptId(), employeeEntity.getDepartment().getName());
			employees.add(new Employee(employeeEntity.getEmployeeId(), employeeEntity.getName(), employeeEntity.getSal(), department));
		}
		return employees;
	}

	@Override
	public List<Department> getAllDepartments() {
		List<DepartmentEntity> departmentEntityList = departmentRepo.findAll();
		List<Department> departments = new ArrayList<Department>();
		for(DepartmentEntity departmentEntity: departmentEntityList) {
			departments.add(new Department(departmentEntity.getDeptId(), departmentEntity.getName()));
		}
		return departments;
	}
	
	@Override
	public Employee getEmployeeById(long empId) throws EmployeeNotFoundException {
		Optional<EmployeeEntity> opEmployeeEntity = employeeRepo.findById(empId);
		if(opEmployeeEntity.isPresent()) {
			EmployeeEntity employeeEntity = opEmployeeEntity.get();
			Department department = new Department(employeeEntity.getDepartment().getDeptId(), employeeEntity.getDepartment().getName());
			return new Employee(employeeEntity.getEmployeeId(), employeeEntity.getName(), employeeEntity.getSal(), department);
		}
		else {
			throw new EmployeeNotFoundException("empId: " + empId);
		}
	}
}
