package com.bug.report.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bug.report.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
