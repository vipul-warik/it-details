package com.demo.it.services;

import java.util.List;

import com.demo.it.models.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee,long orgId);
	
	Employee getEmployeeById(long employee_id);
	
	List<Employee> getAllEmployees();
	
	Employee updateEmployee(Employee employee,long employeeId);
	
	Employee deleteEmployee(long employee_id);
}
