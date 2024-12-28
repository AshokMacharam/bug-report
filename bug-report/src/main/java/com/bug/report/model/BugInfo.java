//package com.bug.report.model;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
//import jakarta.persistence.ManyToOne;
//
//@Entity
//public class BugInfo {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long bugId;
//	private String bugTitle;
//	private String description;
//	
//	@ManyToOne
//    @JoinColumn(name = "assigned_to", referencedColumnName = "employeeId", nullable = false)
//    private Employee assignedTo;
//
//    @ManyToOne
//    @JoinColumn(name = "assigned_by", referencedColumnName = "employeeId", nullable = false)
//    private Employee assignedBy;
//    
//    private String createdTime;
//    private String lastUpdatedTime;
//    @ManyToOne
//    @JoinColumn(name="project_code",referencedColumnName = "projectCode", nullable = false)
//    private ProjectInfo projectInfo;
//    
////    @JoinColumn(name="project_code")
////    private Long projectCode;
//    private String os;
//    private String type;
//    private String browser;
//    private String priority;
//    private String severity;
//	public Long getBugId() {
//		return bugId;
//	}
//	public void setBugId(Long bugId) {
//		this.bugId = bugId;
//	}
//	public String getBugTitle() {
//		return bugTitle;
//	}
//	public void setBugTitle(String bugTitle) {
//		this.bugTitle = bugTitle;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//
//	public Employee getAssignedTo() {
//		return assignedTo;
//	}
//	public void setAssignedTo(Employee assignedTo) {
//		this.assignedTo = assignedTo;
//	}
//	public Employee getAssignedBy() {
//		return assignedBy;
//	}
//	public void setAssignedBy(Employee assignedBy) {
//		this.assignedBy = assignedBy;
//	}
//	public String getCreatedTime() {
//		return createdTime;
//	}
//	public void setCreatedTime(String createdTime) {
//		this.createdTime = createdTime;
//	}
//	public String getLastUpdatedTime() {
//		return lastUpdatedTime;
//	}
//	public void setLastUpdatedTime(String lastUpdatedTime) {
//		this.lastUpdatedTime = lastUpdatedTime;
//	}
////	public Long getProjectCode() {
////		return projectCode;
////	}
////	public void setProjectCode(Long projectCode) {
////		this.projectCode = projectCode;
////	}
//	
//	public String getOs() {
//		return os;
//	}
//	public void setOs(String os) {
//		this.os = os;
//	}
//	public ProjectInfo getProjectInfo() {
//		return projectInfo;
//	}
//	public void setProjectInfo(ProjectInfo projectInfo) {
//		this.projectInfo = projectInfo;
//	}
//	public String getType() {
//		return type;
//	}
//	public void setType(String type) {
//		this.type = type;
//	}
//	public String getBrowser() {
//		return browser;
//	}
//	public void setBrowser(String browser) {
//		this.browser = browser;
//	}
//	public String getPriority() {
//		return priority;
//	}
//	public void setPriority(String priority) {
//		this.priority = priority;
//	}
//	public String getSeverity() {
//		return severity;
//	}
//	public void setSeverity(String severity) {
//		this.severity = severity;
//	}
//}


package com.bug.report.model;

import jakarta.persistence.*;

@Entity
public class BugInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bugId;

    private String bugTitle;
    private String description;

    @ManyToOne
    @JoinColumn(name = "assigned_to", referencedColumnName = "employeeId", nullable = false)
    private Employee assignedTo;

    @ManyToOne
    @JoinColumn(name = "assigned_by", referencedColumnName = "employeeId", nullable = false)
    private Employee assignedBy;

    private String createdTime;
    private String lastUpdatedTime;

    @ManyToOne
    @JoinColumn(name = "project_code", referencedColumnName = "project_code", nullable = false)
    private ProjectInfo projectInfo;

    private String os;
    private String type;
    private String browser;
    private String priority;
    private String severity;

    // Getters and Setters
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

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Employee getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Employee assignedBy) {
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

    public ProjectInfo getProjectInfo() {
        return projectInfo;
    }

    public void setProjectInfo(ProjectInfo projectInfo) {
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

