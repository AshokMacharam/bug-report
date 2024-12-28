package com.bug.report.dto;

public class EmployeeRequest {
	
	private Long employeeId;
	private String employeeName;
	private int role; // Enum ordinal
//	private boolean deleteFlag;
	private Long projectCode;

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

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

//	public boolean isDeleteFlag() {
//		return deleteFlag;
//	}
//
//	public void setDeleteFlag(boolean deleteFlag) {
//		this.deleteFlag = deleteFlag;
//	}

	public Long getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(Long projectCode) {
		this.projectCode = projectCode;
	}

//	public EmployeeRequest(Long employeeId, String employeeName, int role, Long projectCode) {
//		super();
//		this.employeeId = employeeId;
//		this.employeeName = employeeName;
//		this.role = role;
//		this.projectCode = projectCode;
//	}
	
	
}