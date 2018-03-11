package com.employee.manager.repository;

import java.util.List;

import com.employee.manager.domain.Department;

public interface DepartmentRepository {
	
	List<Department> getDepartments();
	Department getDepartment(Long theId);
	void deleteDepartment(Long theId);
	void saveDepartment(Department theDepartment);
	List<String> getDepartmentNames();

}
