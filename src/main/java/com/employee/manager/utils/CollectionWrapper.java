package com.employee.manager.utils;

import java.util.HashSet;
import java.util.Set;

import com.employee.manager.domain.Department;
import com.employee.manager.domain.Employee;
import com.employee.manager.domain.Project;

public class CollectionWrapper {
	
private Set<Employee> employees = new HashSet<>();
private Set<Project> projects = new HashSet<>();
private Set<Department> departments = new HashSet<>();
public Set<Employee> getEmployees() {
	return employees;
}
public void setEmployees(Set<Employee> employees) {
	this.employees = employees;
}
public Set<Project> getProjects() {
	return projects;
}
public void setProjects(Set<Project> projects) {
	this.projects = projects;
}
public Set<Department> getDepartments() {
	return departments;
}
public void setDepartments(Set<Department> departments) {
	this.departments = departments;
}



}
