package com.spring.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="emp")
public class EmployeeEntity {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long employeeId;

	@Column(name="name")
	private String name;
	
	@Column(name="sal")
	private double sal;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="deptid")
	private DepartmentEntity department;
	
	public EmployeeEntity() {
		
	}

	public EmployeeEntity(Long employeeId, String name, double sal, DepartmentEntity department) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.sal = sal;
		this.department = department;
	}

	public EmployeeEntity(String name, double sal, DepartmentEntity department) {
		super();
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

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "EmployeeEntity [employeeId=" + employeeId + ", name=" + name + ", sal=" + sal + ", department="
				+ department + "]";
	}
	
}