package com.spring.json;

public class Department {

	private Long deptId;
	private String name;

	public Department() {		
	}

	public Department(Long deptId, String name) {
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

	@Override
	public String toString() {
		return "DepartmentEntity [deptId=" + deptId + ", name=" + name + "]";
	}
	
}