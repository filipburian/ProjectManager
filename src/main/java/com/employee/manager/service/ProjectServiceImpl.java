package com.employee.manager.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.manager.domain.Project;
import com.employee.manager.repository.DepartmentRepository;
import com.employee.manager.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
	{
	    Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Transactional
	public List<Project> getProjects() {
		return projectRepository.getProjects();
	}
	
	@Transactional
	public Map<Long, String> getProjectsIdMap() {
		
		Map<Long, String> projectsIdMap =
				projectRepository.getProjects().stream().filter(distinctByKey(Project::getProjectName))
				.collect(Collectors.toMap(Project::getId, Project::getProjectName));
		
	/*	projectsIdMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue)->oldValue, LinkedHashMap::new));*/
			
		return projectsIdMap;	
		
	}
	
	@Transactional
	public Map<String, String> getProjectsStringIdMap() {
		
		Map<String, String> projectsIdMap =
				projectRepository.getProjects().stream().filter(distinctByKey(Project::getProjectName))
				.collect(Collectors.toMap(Project::toString, Project::getProjectName));
		
	/*	projectsIdMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue)->oldValue, LinkedHashMap::new));*/
			
		return projectsIdMap;	
		
	}

	@Transactional
	public Project getProject(Long theId) {
		return projectRepository.getProject(theId);
	}

	@Transactional
	public void deleteProject(Long theId) {
		projectRepository.deleteProject(theId);

	}

	@Transactional
	public void saveProject(Project theProject) {
		projectRepository.saveProject(theProject);

	}

	@Override
	public List<String> getProjectNames() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Set<Project> getProjectsSet() {
		Set<Project> projects = projectRepository.getProjects().stream().collect(Collectors.toSet());
		return projects;
	}



}
