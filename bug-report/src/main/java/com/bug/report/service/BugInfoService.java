package com.bug.report.service;

import java.util.List;

import com.bug.report.model.BugInfo;

public interface BugInfoService {

	BugInfo addBug(BugInfo bugInfo);
	BugInfo getBug(Long bugId);
	List<BugInfo> getAllBugsAssignedTo(Long empId);
	List<BugInfo> getAllBugsAssignedBy(Long empId);
	List<BugInfo> getAllBugsInAProject(Long projectCode);
	
	
	
}
