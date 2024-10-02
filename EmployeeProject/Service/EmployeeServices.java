package com.Forage.EmployeeProject.Service;

import java.util.List;

import com.Forage.EmployeeProject.entity.Employee;

public interface EmployeeServices {
public void SaveEmployee(Employee entity); 
public void UpdateEmployee(Employee entity); 
public Employee getEmployee(int Employee_id);
public List<Employee>getAllEmployee();
public void deleteEmployee (int Employee_id);
Employee getEmployee(Long Employee_id);
}

