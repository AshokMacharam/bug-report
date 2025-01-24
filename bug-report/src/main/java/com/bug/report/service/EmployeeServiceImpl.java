package com.bug.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.report.dto.EmployeeRequest;
import com.bug.report.dto.LoginRequest;
import com.bug.report.exception.EmployeeNotFoundException;
import com.bug.report.model.Employee;
import com.bug.report.model.ProjectInfo;
import com.bug.report.model.Role;
import com.bug.report.repository.EmployeeRepository;
import com.bug.report.repository.ProjectRepository;
import com.bug.report.util.PasswordUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;

	// Employee employee;

	@Override
	public Employee addEmployee(EmployeeRequest employeeRequest) {

		ProjectInfo project = projectRepository.findById(employeeRequest.getProjectCode())
                .orElseThrow(() -> new RuntimeException("Project not found"));
		Employee employee = new Employee();
        employee.setEmployeeId(employeeRequest.getEmployeeId());
        employee.setEmployeeName(employeeRequest.getEmployeeName());
        //employee.setRole(Role.values()[employeeRequest.getRole()]); // Map ordinal to enum
        employee.setRole(employeeRequest.getRole());
        employee.setHashedPassword(PasswordUtil.hashPassword(employeeRequest.getPassword()));
        employee.setDeleteFlag(false);
        employee.setProjectInfo(project);

		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Employee getEmployee(Long employeeId) throws EmployeeNotFoundException {
		Employee employee = employeeRepository.findById(employeeId).get();
		if(employee.isDeleteFlag())
		{
			throw new EmployeeNotFoundException("Employee with given Id is inactive");
		}
		else
		return employee;
	}

	@Override
	public Employee updateEmployee(Long employeeId, EmployeeRequest employeeRequest) throws EmployeeNotFoundException {

		if (employeeRepository.existsById(employeeId) == false) {
			throw new EmployeeNotFoundException("Employee with given employee id not found");
		}
		Employee emp = employeeRepository.findById(employeeId).get();
		if (employeeRequest.getEmployeeName() != null) {
	        emp.setEmployeeName(employeeRequest.getEmployeeName());
	    }
//		if (employeeRequest.getRole() >= 0 && employeeRequest.getRole() < Role.values().length) {
//		    emp.setRole(Role.values()[employeeRequest.getRole()]);
//		} else {
//		    throw new IllegalArgumentException("Invalid role value provided: " + employeeRequest.getRole());
//		}
		if(employeeRequest.getRole()!=null) {
			emp.setRole(employeeRequest.getRole());
		}
		if(employeeRequest.getProjectCode() != null) {
			ProjectInfo project = projectRepository.findById(employeeRequest.getProjectCode())
	                .orElseThrow(() -> new RuntimeException("Project not found"));
			emp.setProjectInfo(project);
		}
		if(employeeRequest.getPassword() !=null) {
			emp.setHashedPassword(PasswordUtil.hashPassword(employeeRequest.getPassword()));
		}
		return employeeRepository.save(emp);

	}

	@Override
	public List<Employee> getAllEmployeesByRole(String role) {
		return employeeRepository.getEmployeesByRole(role);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}
	@Override
	public List<Employee> getAllEmployeesInAProject(Long projectCode) {
		return employeeRepository.getEmployeeByProjectCode(projectCode);
	}

	@Override
	public String deleteEmployee(Long employeeId) {
		Employee emp = employeeRepository.findById(employeeId).get();
		emp.setDeleteFlag(true);
		employeeRepository.save(emp);
		return "Employee with id "+employeeId+" has been deleted";
	}


}
