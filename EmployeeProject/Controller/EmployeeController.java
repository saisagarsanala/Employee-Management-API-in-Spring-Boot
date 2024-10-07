package com.Forage.EmployeeProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Forage.EmployeeProject.Service.EmployeeServices;
import com.Forage.EmployeeProject.entity.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeServices ServiceLayer;
	
	@PostMapping("/api/add_Employee")
	public int createNewEmployee(@RequestBody Employee entity) {
		
		ServiceLayer.SaveEmployee(entity);
		return entity.getEmployee_id();
		
	}
	@PutMapping("/api/update_Employee")
	public String Update_Employee(@RequestBody Employee entity) {
		ServiceLayer.UpdateEmployee(entity);
		return "Employee Updated SuccessFully";
	}
	@GetMapping("/api/Employee_display/{Employee_id}")
	public Employee EmployeeDisplay(@PathVariable int Employee_id) {
		return ServiceLayer.getEmployee(Employee_id);
	}
	@GetMapping("/api/getAllEmp")
	public List<Employee>getAllEmployees(){
		return ServiceLayer.getAllEmployee();
	}
	
	@DeleteMapping("/api/delete_employee{Employee_id}")
	public String DeleteEmp(@PathVariable int Employee_id) {
		return "Employee Deleted";
		
	}
	
}
