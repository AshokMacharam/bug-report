package com.bug.report.service;

import java.util.List;

import com.bug.report.dto.EmployeeRequest;
import com.bug.report.model.Employee;
import com.bug.report.model.EmployeeProject;
import com.bug.report.model.ProjectInfo;

public interface ProjectService {
	
	ProjectInfo addProject(ProjectInfo project);
	ProjectInfo getProject(Long projectCode);
	List<ProjectInfo> getAllProjects();
	//List<EmployeeRequest> getAllEmployeesInProject(Long projectCode);

}
