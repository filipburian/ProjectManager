package com.employee.manager.repository;

import java.util.List;

import com.employee.manager.domain.Employee;

public interface EmployeeRepository {
	
	List<Employee> getEmployees();
	Employee getEmployee(Long theId);
	List<Employee> getEmployeesByLastName(String lastName);
	void deleteEmployee(Long theId);
	void saveEmployee(Employee employee);
}
