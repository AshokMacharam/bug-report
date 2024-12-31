package com.bug.report.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.report.dto.BugInfoRequest;
import com.bug.report.exception.BugNotFoundException;
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

	public BugInfo updateBug(Long bugId, BugInfoRequest bugInfoRequest) throws BugNotFoundException {
        // Fetch the existing bug
        BugInfo bugInfo = bugInfoRepository.findById(bugId)
                .orElseThrow(() -> new BugNotFoundException("Bug not found with ID: " + bugId));

        // Update fields only if they are not null in the request
        if (bugInfoRequest.getBugTitle() != null) {
            bugInfo.setBugTitle(bugInfoRequest.getBugTitle());
        }
        if (bugInfoRequest.getDescription() != null) {
            bugInfo.setDescription(bugInfoRequest.getDescription());
        }
        if (bugInfoRequest.getAssignedTo() != null) {
            Employee assignedTo = employeeRepository.findById(bugInfoRequest.getAssignedTo())
                    .orElseThrow(() -> new IllegalArgumentException("AssignedTo Employee not found"));
            bugInfo.setAssignedTo(assignedTo);
        }
        if (bugInfoRequest.getAssignedBy() != null) {
            Employee assignedBy = employeeRepository.findById(bugInfoRequest.getAssignedBy())
                    .orElseThrow(() -> new IllegalArgumentException("AssignedBy Employee not found"));
            bugInfo.setAssignedBy(assignedBy);
        }
        if (bugInfoRequest.getProjectInfo() != null) {
            ProjectInfo projectInfo = projectRepository.findById(bugInfoRequest.getProjectInfo())
                    .orElseThrow(() -> new IllegalArgumentException("Project not found"));
            bugInfo.setProjectInfo(projectInfo);
        }
        if (bugInfoRequest.getOs() != null) {
            bugInfo.setOs(bugInfoRequest.getOs());
        }
        if (bugInfoRequest.getType() != null) {
            bugInfo.setType(bugInfoRequest.getType());
        }
        if (bugInfoRequest.getBrowser() != null) {
            bugInfo.setBrowser(bugInfoRequest.getBrowser());
        }
        if (bugInfoRequest.getPriority() != null) {
            bugInfo.setPriority(bugInfoRequest.getPriority());
        }
        if (bugInfoRequest.getSeverity() != null) {
            bugInfo.setSeverity(bugInfoRequest.getSeverity());
        }

        // Update the last updated time
        bugInfo.setLastUpdatedTime(java.time.LocalDateTime.now().toString());

        return bugInfoRepository.save(bugInfo);
    }
	
	

}
