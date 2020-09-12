package com.sda.recap.employeemanagementapp.repository;

import com.sda.recap.employeemanagementapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
