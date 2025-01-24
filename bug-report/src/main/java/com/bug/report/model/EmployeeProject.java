package com.bug.report.model;

import java.util.List;

public class EmployeeProject {
	
	private ProjectInfo project;
	private List<Employee> employees;
	public ProjectInfo getProject() {
		return project;
	}
	public void setProject(ProjectInfo project) {
		this.project = project;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

}
