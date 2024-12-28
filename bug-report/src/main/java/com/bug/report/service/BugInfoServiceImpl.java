package com.bug.report.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.report.dto.BugInfoRequest;
import com.bug.report.model.BugInfo;
import com.bug.report.model.Employee;
import com.bug.report.model.ProjectInfo;
import com.bug.report.repository.BugInfoRepository;
import com.bug.report.repository.EmployeeRepository;
import com.bug.report.repository.ProjectRepository;

@Service
public class BugInfoServiceImpl implements BugInfoService{

	@Autowired
	BugInfoRepository bugInfoRepository;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	ProjectRepository projectRepository;
		
	
//	@Override
//	public BugInfo addBug(BugInfo bugInfo) {
//		
//		return bugInfoRepository.save(bugInfo);
//	}
	
	@Override
	public BugInfo addBug(BugInfoRequest bugInfoRequest) {
        // Fetch Employee assignedTo and assignedBy
        Employee assignedTo = employeeRepository.findById(bugInfoRequest.getAssignedTo())
                .orElseThrow(() -> new RuntimeException("AssignedTo Employee not found"));
        Employee assignedBy = employeeRepository.findById(bugInfoRequest.getAssignedBy())
                .orElseThrow(() -> new RuntimeException("AssignedBy Employee not found"));

        // Fetch ProjectInfo
        ProjectInfo projectInfo = projectRepository.findById(bugInfoRequest.getProjectInfo())
                .orElseThrow(() -> new RuntimeException("Project not found"));

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm:ss a");
        String formattedNow = now.format(formatter);
        // Create BugInfo
        BugInfo bugInfo = new BugInfo();
        bugInfo.setBugTitle(bugInfoRequest.getBugTitle());
        bugInfo.setDescription(bugInfoRequest.getDescription());
        bugInfo.setAssignedTo(assignedTo);
        bugInfo.setAssignedBy(assignedBy);
        bugInfo.setCreatedTime(formattedNow);
        bugInfo.setLastUpdatedTime(formattedNow);
        bugInfo.setProjectInfo(projectInfo);
        bugInfo.setOs(bugInfoRequest.getOs());
        bugInfo.setType(bugInfoRequest.getType());
        bugInfo.setBrowser(bugInfoRequest.getBrowser());
        bugInfo.setPriority(bugInfoRequest.getPriority());
        bugInfo.setSeverity(bugInfoRequest.getSeverity());

        // Save BugInfo
        return bugInfoRepository.save(bugInfo);
    }

	@Override
	public BugInfo getBug(Long bugId) {
		return bugInfoRepository.findById(bugId).get();
	}

	@Override
	public List<BugInfo> getAllBugsAssignedTo(Long empId) {
		
		return bugInfoRepository.getAllBugsAssignedTo(empId);
	}

	@Override
	public List<BugInfo> getAllBugsAssignedBy(Long empId) {
		
		return bugInfoRepository.getAllBugsAssignedBy(empId);
	}

	@Override
	public List<BugInfo> getAllBugsInAProject(Long projectCode) {

		return bugInfoRepository.getAllBugsInAProject(projectCode);
	}
	
	

}
