package com.bug.report.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.report.dto.LoginRequest;
import com.bug.report.exception.EmployeeNotFoundException;
import com.bug.report.model.Employee;
import com.bug.report.repository.EmployeeRepository;
import com.bug.report.util.PasswordUtil;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public String login(LoginRequest loginRequest) {
	    Long employeeId = loginRequest.getEmployeeId();
	    String password = loginRequest.getPassword();

	    try {
	        // Fetch the employee by ID
	        Employee employee = employeeRepository.findById(employeeId)
	                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));

	        // Check if the employee is not deleted
	        if (employee.isDeleteFlag()) {
	            return "Employee is deactivated";
	        }

	        // Hash the input password and compare it with the stored password
	        String hashedPassword = PasswordUtil.hashPassword(password);
	        if (hashedPassword.equals(employee.getHashedPassword())) {
	            return "Login successful";
	        } else {
	            return "Invalid credentials";
	        }
	    } catch (EmployeeNotFoundException e) {
	        return e.getMessage(); // "Employee not found"
	    } catch (Exception e) {
	        return "An unexpected error occurred";
	    }
	}



}
