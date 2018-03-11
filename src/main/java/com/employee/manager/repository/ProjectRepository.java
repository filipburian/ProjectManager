package com.employee.manager.repository;

import java.util.List;
import java.util.Map;

import com.employee.manager.domain.Department;
import com.employee.manager.domain.Project;

public interface ProjectRepository {
	
	List<Project> getProjects();
	Project getProject(Long theId);
	void deleteProject(Long theId);
	void saveProject(Project theProject);
	List<String> getProjectNames();

}
