package com.ing.training.repository;

import com.ing.training.model.Employee;

public interface EmployeeRepository {

	Employee getEmployeeById(Long id);

	//Employee saveEmployeeDetails(Employee emp);
	

}
