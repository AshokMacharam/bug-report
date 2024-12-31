package com.bug.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.report.dto.EmployeeRequest;
import com.bug.report.exception.EmployeeNotFoundException;
import com.bug.report.model.Employee;
import com.bug.report.service.EmployeeService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/employee")
@CrossOrigin
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody EmployeeRequest employee) {
		return employeeService.addEmployee(employee);
	}
	
	@GetMapping("/getEmployee/{employeeId}")
	public Employee getEmployee(@PathVariable Long employeeId) throws EmployeeNotFoundException {
		return employeeService.getEmployee(employeeId);
	}
	
	@PutMapping("updateEmployee/{employeeId}")
	public Employee putMethodName(@PathVariable Long employeeId, @RequestBody EmployeeRequest employee) throws EmployeeNotFoundException {
		//TODO: process PUT request
		
		return employeeService.updateEmployee(employeeId, employee);
	}
	
	
	
	@GetMapping("/getAllEmployeeInProject/{projectCode}")
	public List<Employee> getAllEmployeeInProject(@PathVariable Long projectCode) {
		return employeeService.getAllEmployeesInAProject(projectCode);
	}	

}
