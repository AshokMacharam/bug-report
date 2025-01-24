package com.bug.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bug.report.dto.EmployeeRequest;
import com.bug.report.model.Employee;
import com.bug.report.model.EmployeeProject;
import com.bug.report.model.ProjectInfo;
import com.bug.report.service.ProjectService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projectInfo")
@CrossOrigin
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@PostMapping("/addProjectInfo")
	public ProjectInfo addProject(@RequestBody ProjectInfo projectInfo) {

		return projectService.addProject(projectInfo);
	}

	@GetMapping("/getProjectInfo/{projectCode}")
	public ProjectInfo getProjectInfo(@PathVariable Long projectCode) {
		return projectService.getProject(projectCode);
	}
	
	@GetMapping("/getAllProjects")
	public List<ProjectInfo> getAllProjects() {
		return projectService.getAllProjects();
	}
	
//	@GetMapping("/getAllProjectEmployees/{projectCode}")
//	public List<EmployeeRequest> getAllProjectEmployess(@PathVariable Long projectCode) {
//		return projectService.getAllEmployeesInProject(projectCode);
//	}
//	

}
