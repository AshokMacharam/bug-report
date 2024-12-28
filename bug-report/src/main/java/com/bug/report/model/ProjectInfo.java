package com.bug.report.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class ProjectInfo {
	
	@Id
	@Column(name="project_code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectCode;
	private String projectName;
	
	@OneToMany(mappedBy = "projectInfo", cascade=CascadeType.ALL, targetEntity=Employee.class)
	@JsonIgnore
	//private List<Employee> employees=new ArrayList<>();
	private List<Employee> employees=new ArrayList<>();
	
//	@OneToMany(mappedBy = "projectCode", cascade = CascadeType.ALL)
//    private List<BugInfo> BugsList=new ArrayList<BugInfo>();
	
	public Long getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(Long projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployess(List<Employee> employees) {
		this.employees = employees;
	}

}
