package com.Forage.EmployeeProject.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Forage.EmployeeProject.Repository.EmployeeRepository;
import com.Forage.EmployeeProject.entity.Employee;
@Service
public class EmployeeImp implements EmployeeServices{
	
	@Autowired
	private EmployeeRepository Repository;
	
	@Override
	public void SaveEmployee(Employee entity) {
		Repository.save(entity);
	}

	@Override
	public void UpdateEmployee(Employee entity) {
		Repository.save(entity);
	}

	@Override
	public Employee getEmployee(Long Employee_id) {
		
		return Repository.findById(Employee_id).get();
	}

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee>EmployeeList = new ArrayList<Employee>();
		Repository.findAll().forEach(Employe->EmployeeList.add(Employe));
		return EmployeeList;
	}

	@Override
	public void deleteEmployee(int Employee_id) {
		Repository.deleteById((long) Employee_id);
		
	}

	@Override
	public Employee getEmployee(int Employee_id) {
		// TODO Auto-generated method stub
		return getEmployee(1);
	}


}
