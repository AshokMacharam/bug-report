package com.bug.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bug.report.model.BugInfo;

@Repository
public interface BugInfoRepository extends JpaRepository<BugInfo, Long> {

    // Get all bugs assigned to a specific employee
    @Query("SELECT b FROM BugInfo b WHERE b.assignedTo.employeeId = :assignedTo")
    List<BugInfo> getAllBugsAssignedTo(@Param("assignedTo") Long assignedTo);

    // Get all bugs reported by a specific employee
    @Query("SELECT b FROM BugInfo b WHERE b.assignedBy.employeeId = :assignedBy")
    List<BugInfo> getAllBugsAssignedBy(@Param("assignedBy") Long assignedBy);

    // Get all bugs in a specific project
    @Query("SELECT b FROM BugInfo b WHERE b.projectInfo.projectCode = :projectCode")
    List<BugInfo> getAllBugsInAProject(@Param("projectCode") Long projectCode);
}

