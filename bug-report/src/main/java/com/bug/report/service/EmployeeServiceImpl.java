package com.bug.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.report.dto.EmployeeRequest;
import com.bug.report.exception.EmployeeNotFoundException;
import com.bug.report.model.Employee;
import com.bug.report.model.ProjectInfo;
import com.bug.report.model.Role;
import com.bug.report.repository.EmployeeRepository;
import com.bug.report.repository.ProjectRepository;

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
        employee.setRole(Role.values()[employeeRequest.getRole()]); // Map ordinal to enum
        employee.setDeleteFlag(false);
        employee.setProjectInfo(project);

		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		return employeeRepository.findById(employeeId).get();
	}

	@Override
	public Employee updateEmployee(Long employeeId, Employee employee) throws EmployeeNotFoundException {

		if (employeeRepository.existsById(employeeId) == false) {
			throw new EmployeeNotFoundException("Employee with given employee id not found");
		}
		Employee emp = employeeRepository.findById(employeeId).get();
		emp.setEmployeeName(employee.getEmployeeName());
		emp.setRole(employee.getRole());
		return employeeRepository.save(emp);

	}

	@Override
	public List<Employee> getAllEmployeesByRole(Role role) {
		return employeeRepository.getEmployeesByRole(role);
	}

	@Override
	public List<Employee> getAllEmployeesInAProject(Long projectCode) {
		return employeeRepository.getEmployeeByProjectCode(projectCode);
	}

}
