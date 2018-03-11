package com.employee.manager.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.employee.manager.domain.Department;
import com.employee.manager.domain.Project;

public interface ProjectService {
	
	List<Project> getProjects();
	Set<Project> getProjectsSet();
	Map<Long, String> getProjectsIdMap();
	Map<String, String> getProjectsStringIdMap();
	Project getProject(Long theId);
	void deleteProject(Long theId);
	void saveProject(Project theProject);
	List<String> getProjectNames();

}
