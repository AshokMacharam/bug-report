package com.bug.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.report.model.BugInfo;

public interface BugInfoRepository extends JpaRepository<BugInfo,Integer> {

}
