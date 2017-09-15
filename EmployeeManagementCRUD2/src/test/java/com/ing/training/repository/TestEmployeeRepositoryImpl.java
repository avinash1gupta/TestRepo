package com.ing.training.repository;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyCollection;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ing.training.controller.EmployeeController;
import com.ing.training.model.Employee;
import com.ing.training.repository.impl.EmployeeRepositoryImpl;
import com.ing.training.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeRepositoryImpl {
	
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@InjectMocks
	EmployeeRepositoryImpl employeeRepositoryImpl;
	
	@Test
	public void testGetEmployeeById(){
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setName("viv");
		
		
		Employee returnEmp = new Employee();
		returnEmp.setId(1L);
		returnEmp.setName("viv");
		when(employeeRepositoryImpl.getEmployeeById(1L)).thenReturn(returnEmp);
		assertEquals("viv", returnEmp.getName());

		
		
	}

}
