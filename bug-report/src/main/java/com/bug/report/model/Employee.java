package com.bug.report.model;

import jakarta.persistence.Entity;

@Entity
public class Employee {

	private int employeeId;
	private int employeeName;
	private Role role;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(int employeeName) {
		this.employeeName = employeeName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
