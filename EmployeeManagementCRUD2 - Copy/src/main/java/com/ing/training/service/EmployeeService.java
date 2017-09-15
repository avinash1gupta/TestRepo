package com.ing.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.training.model.Employee;
import com.ing.training.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee getEmployeeById(Long id){
		return employeeRepository.getEmployeeById(id);
	}

//	public Employee saveEmployeeDetails(Employee emp) {
//		return employeeRepository.saveEmployeeDetails(emp);
//	}

}
