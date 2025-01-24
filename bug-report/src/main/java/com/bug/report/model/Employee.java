package com.bug.report.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;

    private String employeeName;

    //@Enumerated(EnumType.STRING)
    private String role;

    @ManyToOne
    @JoinColumn(name = "project_code", referencedColumnName = "project_code", nullable = false)
    private ProjectInfo projectInfo;

    @JsonIgnore
    private boolean deleteFlag;
    
    @JsonIgnore
    private String hashedPassword;

    @OneToMany(mappedBy = "assignedTo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<BugInfo> assignedBugs;

    @OneToMany(mappedBy = "assignedBy", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<BugInfo> reportedBugs;

    // Getters and Setters
    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String password) {
		this.hashedPassword = password;
	}

	public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(ProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public List<BugInfo> getAssignedBugs() {
        return assignedBugs;
    }

    public void setAssignedBugs(List<BugInfo> assignedBugs) {
        this.assignedBugs = assignedBugs;
    }

    public List<BugInfo> getReportedBugs() {
        return reportedBugs;
    }

    public void setReportedBugs(List<BugInfo> reportedBugs) {
        this.reportedBugs = reportedBugs;
    }
}

