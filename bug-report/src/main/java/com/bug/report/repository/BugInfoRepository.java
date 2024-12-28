package com.bug.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bug.report.model.BugInfo;
import com.bug.report.model.Employee;

@Repository
public interface BugInfoRepository extends JpaRepository<BugInfo,Long> {
	
	@Query("SELECT b FROM BugInfo b WHERE b.assignedTo = :assignedTo")
    List<BugInfo> getAllBugsAssignedTo(@Param("assignedTo") Long asssignedTo);
	@Query("SELECT b FROM BugInfo b WHERE b.assignedBy = :assignedBy")
	List<BugInfo> getAllBugsAssignedBy(@Param("assignedBy") Long asssignedBy);
	
	@Query("SELECT b FROM BugInfo b WHERE b.projectCode = :projectCode")
	List<BugInfo> getAllBugsInAProject(@Param("projectCode") Long projectCode);
	
	

}
