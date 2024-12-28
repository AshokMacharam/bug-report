package com.bug.report.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bug.report.dto.EmployeeRequest;
import com.bug.report.model.Employee;
import com.bug.report.model.ProjectInfo;

public interface ProjectRepository extends JpaRepository<ProjectInfo, Long>{
	
	//@Query("SELECT e FROM employee e JOIN project_info p ON e.project_code = p.project_code WHERE p.project_code = :project_code")
	//List<Employee> findAllEmployeeByProjectCode(@Param("project_code") Long projectCode);
	//List<Employee> findAllEmployeesByProjectCode(Long projectCode);
	
//	@Query("SELECT e FROM Employee e JOIN e.projectInfo p WHERE p.projectCode = :projectCode")
//	List<Employee> findAllEmployeesByProjectCode(@Param("projectCode")Long projectCode);
	
//	@Query("SELECT e.employeeId, e.employeeName, e.role,p.projectCode " +
//	           "FROM Employee e JOIN e.projectInfo p WHERE p.projectCode = :projectCode")
//	@Query("SELECT e.employeeId, e.employeeName,  e.role FROM bugreport.employee e"
//			+ "JOIN bugreport.projectInfo p ON e.projectCode = p.projectCode"
//			+ "WHERE p.projectCode = :projectCode ")
//	@Query("SELECT new EmployeeRequest (e.employeeId, e.employeeName, e.role,e.projectCode )" +
//		       "FROM Employee e JOIN e.projectInfo p " +
//		       "WHERE p.projectCode = :projectCode")
//	    List<EmployeeRequest> findAllEmployeesByProjectCode(@Param("projectCode") Long projectCode);

}
