package com.bug.report.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bug.report.dto.BugInfoRequest;
import com.bug.report.model.BugInfo;
import com.bug.report.service.BugInfoService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



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
	
	@GetMapping("/getAllBugsAssignedTo/{employeeId}")
	public List<BugInfo> getAllBugsAssignedTo(@PathVariable Long employeeId) {
		return bugInfoService.getAllBugsAssignedTo(employeeId);
	}
	
	@GetMapping("/getAllBugsAssignedBy/{employeeId}")
	public List<BugInfo> getAllBugsAssignedBy(@PathVariable Long employeeId) {
		return bugInfoService.getAllBugsAssignedBy(employeeId);
	}
	

}
