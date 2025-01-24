package com.bug.report.service;

import java.util.List;

import com.bug.report.dto.BugInfoRequest;
import com.bug.report.exception.BugNotFoundException;
import com.bug.report.model.BugInfo;

public interface BugInfoService {

	BugInfo addBug(BugInfoRequest bugInfoRequest);
	BugInfo getBug(Long bugId);
	List<BugInfo> getAllBugsAssignedTo(Long empId);
	List<BugInfo> getAllBugs();
	List<BugInfo> getAllBugsAssignedBy(Long empId);
	List<BugInfo> getAllBugsInAProject(Long projectCode);
	BugInfo updateBug(Long bugId, BugInfoRequest bugInfoRequest) throws BugNotFoundException;
	
	
	
}
