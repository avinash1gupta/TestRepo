package com.ing.training.repository.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.ing.training.controller.EmployeeController;
import com.ing.training.model.Employee;
import com.ing.training.repository.EmployeeRepository;

@Repository("employeeRepository")
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	

	@Override
	public Employee getEmployeeById(Long id) {
		String getEmployeeByIdQuery = "SELECT * FROM employee WHERE id=?";

		try {
			return jdbcTemplate.queryForObject(getEmployeeByIdQuery, new Object[] { id }, (rs, rowNum) -> {

				Employee emp = new Employee();
				emp.setId(rs.getLong("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				return emp;

			});
		} catch (Exception e) {
			
			logger.error(e.getMessage());		}

		return null;

	}

//	@Override
//	public Employee saveEmployeeDetails(Employee emp) {
//		Employee tempEmp = new Employee();
//		try {
//			if (emp != null) {
//				jdbcTemplate.update("INSERT INTO hclEmployee.employee(id, name,salary) VALUES(?,?,?)",
//						emp.getId(),emp.getName(),emp.getSalary());
//				tempEmp = getEmployeeById(emp.getId());
//			}
//			else{
//				return new Employee();
//			}
//		} catch (DataAccessException e) {
//			logger.error(e.getMessage());
//			}
//
//		return tempEmp;
//	}

}
