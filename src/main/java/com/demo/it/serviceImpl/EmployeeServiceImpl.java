package com.demo.it.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.demo.it.exceptions.ResourceNotFoundException;
import com.demo.it.models.Employee;
import com.demo.it.models.Organization;
import com.demo.it.repositories.EmployeeRepository;
import com.demo.it.repositories.OrganizationRepository;
import com.demo.it.services.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OrganizationRepository organizationRepository;


	@Override
	public Employee saveEmployee(Employee employee,long orgId) {
		
		Organization existingOrg = organizationRepository.findById(orgId).orElseThrow(() -> new ResourceNotFoundException("Organizition","Id",orgId));
		employee.setOrganization(existingOrg);
		return employeeRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long employee_id) {
		
		Employee employee = employeeRepository.findById(employee_id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employee_id));
		
		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee updateEmployee(Employee employee,long employeeId) {
		
		Employee existingEmp = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employeeId));
		
		existingEmp.setDepartment(employee.getDepartment());
		existingEmp.setDesignation(employee.getDesignation());
		existingEmp.setName(employee.getName());
		existingEmp.setOrganization(employee.getOrganization());
		existingEmp.setProject(employee.getProject());
		
		employeeRepository.save(existingEmp);
		
		return existingEmp;
	}

	@Override
	public Employee deleteEmployee(long employee_id) {
		
		Employee employee = employeeRepository.findById(employee_id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", employee_id));
		
		employeeRepository.delete(employee);
		
		return employee;
	}

}
