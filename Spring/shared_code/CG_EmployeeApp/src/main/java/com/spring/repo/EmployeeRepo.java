package com.spring.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long>{
	//List<Employee> findByNameAndSal(String name, double sal);
}
