package com.bug.report.service;

import java.util.List;

import com.bug.report.dto.EmployeeRequest;
import com.bug.report.exception.EmployeeNotFoundException;
import com.bug.report.model.Employee;
import com.bug.report.model.Role;

public interface EmployeeService {

	Employee addEmployee(EmployeeRequest employee);
	Employee getEmployee(Long employeeId);
	Employee updateEmployee(Long employeeId,Employee employee) throws EmployeeNotFoundException;
	List<Employee> getAllEmployeesByRole(Role role);
	List<Employee> getAllEmployeesInAProject(Long projectCode);
	//String deleteEmployee(Long employeeNumber);
	//List<Employee> listOfEmployeeWithSameDepartment(String departmentCode);
	//EmployeeDepartment listOfEmployeeWithDepartmentDetails(String departmentCode);
}
