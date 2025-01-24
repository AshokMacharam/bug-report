package com.bug.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.report.dto.EmployeeRequest;
import com.bug.report.model.Employee;
import com.bug.report.model.EmployeeProject;
import com.bug.report.model.ProjectInfo;
import com.bug.report.repository.EmployeeRepository;
import com.bug.report.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;	
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public ProjectInfo addProject(ProjectInfo project) {
		return projectRepository.save(project);
	}

	@Override
	public ProjectInfo getProject(Long projectCode) {
		//Project
		return projectRepository.findById(projectCode).get();
	}

	@Override
	public List<ProjectInfo> getAllProjects() {
		return projectRepository.findAll();
	}

//	@Override
//	public List<EmployeeRequest> getAllEmployeesInProject(Long projectCode) {
//		
////		EmployeeProject employeeProject = new EmployeeProject();
////		List<Employee> employees = employeeRepository.getEmployeeByProjectCode(projectCode);
////		ProjectInfo project = projectRepository.findById(projectCode).get();
////		employeeProject.setEmployees(employees);
////		employeeProject.setProject(project);
//		
//		return projectRepository.findAllEmployeesByProjectCode(projectCode);
//		
//	}
}
