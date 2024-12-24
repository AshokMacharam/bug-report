package com.bug.report.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BugInfo {

	private int bugId;
	private String description;
	private String assignedBy;
	private String assignedTo;
	
	@Id
	public int getBugId() {
		return bugId;
	}
	public void setBugId(int bugId) {
		this.bugId = bugId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	
}
