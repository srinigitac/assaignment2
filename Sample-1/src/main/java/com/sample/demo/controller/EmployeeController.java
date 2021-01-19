package com.sample.demo.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.entity.Employee;
import com.sample.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	private static final Logger logger =LogManager.getLogger(EmployeeController.class);
	
	@GetMapping("/getallemployee")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		logger.info("Fetching all employees");
		List<Employee> employees=employeeService.getAllEmployee();
		logger.info("All emplees are fetched");
		return new ResponseEntity<List<Employee>>(employees,HttpStatus.OK);
	}
	
	@PutMapping("/updateemployee")
	public ResponseEntity<Employee> updateEmployees(Integer integer) {
		logger.info("Updating employee");
		Employee employee= employeeService.updateEmployee(integer);
		logger.info("Employee updated");
		return new ResponseEntity<Employee>(employee,HttpStatus.OK);
	}
	
	@PostMapping("/saveemployees")
	public ResponseEntity<List<Employee>> updateEmployees(List<Employee> employees) {
		logger.info("Saving Employee");
		List<Employee> empl= employeeService.save(employees);
		logger.info("Saved employee");
		return new ResponseEntity<List<Employee>>(empl,HttpStatus.OK);
	}
	
	@PutMapping("/deleteemployee")
	public ResponseEntity<String> deleteEmployees(Integer id) {
		logger.info("Deleting employee");
		String str=employeeService.deleteEmployee(id);
		logger.info("Employee deleted");
		return new ResponseEntity<String>(str,HttpStatus.OK);
	}

	
	
	
}
