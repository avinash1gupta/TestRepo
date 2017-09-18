package com.ing.training.controller;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ing.training.model.Employee;
import com.ing.training.service.EmployeeService;

@Controller
public class EmployeeController {
	/* This is for Injection */	
	@Inject
	EmployeeService employeeService;
	
	private static final Logger logger = Logger.getLogger(EmployeeController.class);

	
	@RequestMapping(value = "/employee/{id}", method = RequestMethod.GET,  produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseBody
	public Employee getEmployeeById(@PathVariable("id") Long number) {
		
		Employee emp = null;
		try{
			emp = employeeService.getEmployeeById(number);
		}catch(Exception e){
				logger.error(e.getMessage());	
				}
		return emp;
	}

	
//	@RequestMapping(value = "/employee/add", method = RequestMethod.POST,  produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
//	@ResponseBody
//	public Employee saveEmployeeDetails(Employee emp) {
//		
//		Employee newemp = null;
//		try{
//			newemp = employeeService.saveEmployeeDetails(emp);
//		}catch(Exception e){
//
//logger.error(e.getMessage());			}
//		return newemp;
//	}
	
}
