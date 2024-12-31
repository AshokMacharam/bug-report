package com.bug.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bug.report.model.Employee;
import com.bug.report.model.Role;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.role = :role AND e.deleteFlag = false")
    List<Employee> getEmployeesByRole(@Param("role") Role role);

	//@Query("SELECT e FROM Employee e WHERE e.projectInfo = :projectCode")
	@Query("SELECT e FROM Employee e JOIN e.projectInfo p WHERE p.projectCode = :projectCode AND e.deleteFlag = false")
	List<Employee> getEmployeeByProjectCode(@Param("projectCode") Long projectCode);

	
}
