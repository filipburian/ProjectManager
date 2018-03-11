package com.employee.manager.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.manager.domain.Address;
import com.employee.manager.domain.Department;
import com.employee.manager.domain.Employee;
import com.employee.manager.domain.Project;
import com.employee.manager.service.DepartmentService;
import com.employee.manager.service.EmployeeService;
import com.employee.manager.service.ProjectService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));

		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class, stringTrimmer);
	}

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private ProjectService projectService;
	

	@GetMapping()
	public String getDepartments(Model theModel) {

		theModel.addAttribute("departments", departmentService.getDepartments());
		return "list-of-departments";
	}
	
	@GetMapping("/department/{id}")
	public String getDepartmentById(Model theModel, @PathVariable("id") Long departmentId) {
	
		theModel.addAttribute("department", departmentService.getDepartment(departmentId));
		return "department";
	}
	
	@GetMapping("/showDepartmentForm")
	public String addDepartment(Model theModel) {
		
		Department theDepartment = new Department();
		//theModel.addAttribute(projectService.getProjectsIdMap());
		theModel.addAttribute(theDepartment);
		
		return "department-form";
	}
	
	@PostMapping("/saveDepartment")
	public String saveDepartment(@ModelAttribute("department") Department theDepartment) {
		
		departmentService.saveDepartment(theDepartment);
		return "redirect:/departments/";
	}
	@GetMapping("/department/updateDepartment")
	public String updateDepartment(@RequestParam("departmentId") Long departmentId, Model theModel) {
		
		theModel.addAttribute("department", departmentService.getDepartment(departmentId));
	
		
		return "department-form";
	}
	
	@GetMapping("/department/deleteDepartment")
	public String deleteDepartment(@RequestParam("departmentId") Long departmentId, Model theModel) {
		
		departmentService.deleteDepartment(departmentId);
	
		return "redirect:/departments/";
	}
}






