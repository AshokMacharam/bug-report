package com.bug.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.report.dto.BugInfoRequest;
import com.bug.report.exception.BugNotFoundException;
import com.bug.report.model.BugInfo;
import com.bug.report.service.BugInfoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("/bug")
@CrossOrigin
public class BugInfoController {
	
	@Autowired
	BugInfoService bugInfoService;
	
	@PostMapping("/addBug")
	public BugInfo assBugInfo(@RequestBody BugInfoRequest bugInfoRequest) {
		//TODO: process POST request
		
		return bugInfoService.addBug(bugInfoRequest);
	}
	
	@GetMapping("/getBug/{bugId}")
	public BugInfo getBug(@PathVariable Long bugId) {
		return bugInfoService.getBug(bugId);
	}
	
	@GetMapping("/getAllBugs")
	public List<BugInfo> getAllBug() {
		return bugInfoService.getAllBugs();
	}
	
	@GetMapping("/getAllBugsAssignedTo/{employeeId}")
	public List<BugInfo> getAllBugsAssignedTo(@PathVariable Long employeeId) {
		return bugInfoService.getAllBugsAssignedTo(employeeId);
	}
	
	@GetMapping("/getAllBugsAssignedBy/{employeeId}")
	public List<BugInfo> getAllBugsAssignedBy(@PathVariable Long employeeId) {
		return bugInfoService.getAllBugsAssignedBy(employeeId);
	}
	
	@PutMapping("updateBug/{BugId}")
	public BugInfo updateBug(@PathVariable Long BugId, @RequestBody BugInfoRequest bugRequest) throws BugNotFoundException {		
		return bugInfoService.updateBug(BugId, bugRequest);
	}

}
