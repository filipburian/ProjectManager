package com.employee.manager.service;

import java.util.List;
import java.util.Map;

import com.employee.manager.domain.Department;

public interface DepartmentService {
	
	List<Department> getDepartments();
	Map<Long, String> getDepartmentsIdMap();
	Department getDepartment(Long theId);
	void deleteDepartment(Long theId);
	void saveDepartment(Department theDepartment);
	List<String> getDepartmentNames();

}
