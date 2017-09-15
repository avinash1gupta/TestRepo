package com.ing.training.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import com.ing.training.model.Employee;
import com.ing.training.repository.EmployeeRepository;
import com.ing.training.repository.impl.EmployeeRepositoryImpl;
import com.ing.training.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeService {
	
	@Mock
	EmployeeRepositoryImpl employeeRepositoryImpl;
	
	@InjectMocks
	EmployeeService employeeService;
	
	@Test
	public void testGetEmployeeById(){
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setName("Raj");
		
		when(employeeRepositoryImpl.getEmployeeById(1L)).thenReturn(emp);
		
		Employee tempEmp = employeeService.getEmployeeById(1L);
		assertEquals("Raj", tempEmp.getName());
		
	}
	
}
