package com.spring.entity;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="dept")
public class DepartmentEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long deptId;

	@Column(name="name")
	private String name;

	@OneToMany(cascade={CascadeType.ALL}, 
			fetch=FetchType.EAGER, mappedBy = "department")
	private Set<EmployeeEntity> employees;

	public DepartmentEntity() {		
	}

	public DepartmentEntity(Long deptId, String name, Set<EmployeeEntity> employees) {
		super();
		this.deptId = deptId;
		this.name = name;
		this.employees = employees;
	}

	public DepartmentEntity(String name, Set<EmployeeEntity> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}

	public DepartmentEntity(Long deptId, String name) {
		super();
		this.deptId = deptId;
		this.name = name;
	}
	
	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<EmployeeEntity> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<EmployeeEntity> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", name=" + name + "]";
	}
	
}