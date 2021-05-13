package com.spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import com.spring.json.Employee;

class EmployeeControllerTest {

	@Test
	public void testFindEmployeeById() {
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = 
		restTemplate.getForObject("http://localhost:8080/myapp/employee/110", 
				Employee.class);
		assertNotNull(employee);
	}

}
