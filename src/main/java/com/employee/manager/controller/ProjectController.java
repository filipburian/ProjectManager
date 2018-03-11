package com.employee.manager.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.manager.domain.Employee;
import com.employee.manager.domain.Project;
import com.employee.manager.service.DepartmentService;
import com.employee.manager.service.EmployeeService;
import com.employee.manager.service.ProjectService;
import com.employee.manager.utils.CollectionWrapper;
import com.employee.manager.validator.CustomEmployeeSetEditor;

@Controller
@RequestMapping("/projects")
public class ProjectController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Set.class, customEmployeeSetEditor);
	}

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	CustomEmployeeSetEditor customEmployeeSetEditor;

	@GetMapping()
	public String getProjects(Model theModel) {

		theModel.addAttribute("projects", projectService.getProjects());
		return "list-of-projects";
	}

	@GetMapping("/project/{id}")
	public String getProjectById(Model theModel, @PathVariable("id") Long projectId) {

		theModel.addAttribute("project", projectService.getProject(projectId));
		return "project";
	}

	@GetMapping("/showProjectForm")
	public String addProject(Model theModel) {

		Project theProject = new Project();
		theModel.addAttribute("project", theProject);
		theModel.addAttribute("departments", departmentService.getDepartments());

		return "project-form";
	}

	@PostMapping("/saveProject")
	public String saveProject(@ModelAttribute("project") Project theProject) {

		// theProject.setDepartment(departmentService.getDepartment(theProject.getDepartmentId()));
		projectService.saveProject(theProject);

		return "redirect:/projects/";
	}

	@GetMapping("/project/{id}/updateProject")
	public String updateProject(@PathVariable("id") Long projectId, Model theModel) {

		theModel.addAttribute("project", projectService.getProject(projectId));
		theModel.addAttribute("departments", departmentService.getDepartments());

		return "project-form";
	}

	@GetMapping("/project/{id}/deleteProject")
	public String deleteProject(@PathVariable("id") Long projectId, Model theModel) {

		projectService.deleteProject(projectId);

		return "redirect:/projects/";
	}

	@GetMapping("/project/{id}/removeEmployee")
	public String removeEmployee(@PathVariable("id") Long projectId, Model theModel) {

		CollectionWrapper wrapper = new CollectionWrapper();
		theModel.addAttribute("collectionWrapper", wrapper);
		theModel.addAttribute("id", projectId);
		theModel.addAttribute("projectEmployees", projectService.getProject(projectId).getEmployees());

		return "remove-employee-form";
	}

	@PostMapping("/project/{id}/removeEmployee")
	public String removeEmployee(@PathVariable("id") Long projectId,
			@ModelAttribute("collectionWrapper") CollectionWrapper collectionWrapper) {

		Set<Employee> employeesToDelete = collectionWrapper.getEmployees();
		
		Project project = projectService.getProject(projectId);
		for(Employee employee : employeesToDelete) {
			employee.getProjects().remove(project);
			employeeService.saveEmployee(employee);
		}

		return "redirect:/projects/";
	}

}
