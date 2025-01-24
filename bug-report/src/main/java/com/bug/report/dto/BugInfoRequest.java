package com.bug.report.dto;

public class BugInfoRequest {

	private Long bugId;

	private String bugTitle;
	private String description;

	private Long assignedTo;
	private Long assignedBy;

	private String createdTime;
	private String lastUpdatedTime;
	private Long projectInfo;

	private String os;
	private String type;
	private String browser;
	private String priority;
	private String severity;
	public Long getBugId() {
		return bugId;
	}
	public void setBugId(Long bugId) {
		this.bugId = bugId;
	}
	public String getBugTitle() {
		return bugTitle;
	}
	public void setBugTitle(String bugTitle) {
		this.bugTitle = bugTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(Long assignedTo) {
		this.assignedTo = assignedTo;
	}
	public Long getAssignedBy() {
		return assignedBy;
	}
	public void setAssignedBy(Long assignedBy) {
		this.assignedBy = assignedBy;
	}
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	public String getLastUpdatedTime() {
		return lastUpdatedTime;
	}
	public void setLastUpdatedTime(String lastUpdatedTime) {
		this.lastUpdatedTime = lastUpdatedTime;
	}
	public Long getProjectInfo() {
		return projectInfo;
	}
	public void setProjectInfo(Long projectInfo) {
		this.projectInfo = projectInfo;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public String getSeverity() {
		return severity;
	}
	public void setSeverity(String severity) {
		this.severity = severity;
	}

}
