package com.ing.training.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.ing.training.model.Employee;
import com.ing.training.service.EmployeeService;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeController {
	
	@Mock
	EmployeeService employeeService;
	
	@InjectMocks
	EmployeeController employeeController;
	
	
	@Test
	public void testGetEmployee(){
		
		Employee emp = new Employee();
		emp.setId(1L);
		emp.setName("Avi");
		emp.setSalary(3.0f);
		when(employeeService.getEmployeeById(1L)).thenReturn(emp);
		
		Employee returnEmp = employeeController.getEmployeeById(1L);
		assertEquals("Avi", returnEmp.getName());
	}

}
