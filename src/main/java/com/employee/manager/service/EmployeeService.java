package com.employee.manager.service;

import java.util.List;
import java.util.Map;

import com.employee.manager.domain.Employee;

public interface EmployeeService {
	
	List<Employee> getEmployees();
	Employee getEmployee(Long theId);
	Map<Long, String> getEmployeesIdMap();
	List<Employee> getEmployeesByLastName(String lastName);
	void deleteEmployee(Long theId);
	void saveEmployee(Employee employee);

}
