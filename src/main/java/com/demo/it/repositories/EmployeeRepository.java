package com.demo.it.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.it.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
		

}
