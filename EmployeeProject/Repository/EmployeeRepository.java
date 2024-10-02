package com.Forage.EmployeeProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Forage.EmployeeProject.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}

