package com.bug.report.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bug.report.model.BugInfo;
import com.bug.report.repository.BugInfoRepository;

@Service
public class BugInfoServiceImpl implements BugInfoService{

	@Autowired
	BugInfoRepository bugInfoRepository;
	
	@Override
	public BugInfo addBug(BugInfo bugInfo) {
		
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
