package com.employee.manager.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.manager.domain.Department;
import com.employee.manager.domain.Employee;
import com.employee.manager.service.DepartmentService;
import com.employee.manager.service.EmployeeService;
import com.employee.manager.service.ProjectService;
import com.employee.manager.validator.CustomProjectSetEditor;
import com.employee.manager.validator.DepartmentIdPropertyEditor;
import com.employee.manager.validator.EmployeeFormValidator;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private DepartmentIdPropertyEditor departmentIdPropertyEditor;
	
	@Autowired
	private CustomProjectSetEditor customProjectSetEditor;
	
	@Autowired
	private EmployeeFormValidator employeeFormValidator;
	
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private ProjectService projectService;

	@Value("#{company_role}")
	private Map<String, String> company_role;

	@Value("#{professional_experience}")
	private Map<String, String> professional_experience;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		//SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		//binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
		//StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		//binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.setValidator(employeeFormValidator);
		binder.registerCustomEditor(Set.class, "projects", customProjectSetEditor);
		//binder.registerCustomEditor(Department.class,"department", departmentIdPropertyEditor);
		//binder.registerCustomEditor(Set.class, "projects", customProjectSetEditor);
	}
	
	@GetMapping()
	public String getEmployees(Model theModel) {

		theModel.addAttribute("employees", employeeService.getEmployees());
		return "list-of-employees";
	}

	@GetMapping("/employee/{id}")
	public String showEmployee(@PathVariable("id") Long employeeId, Model theModel) {

		theModel.addAttribute("employee", employeeService.getEmployee(employeeId));
		return "employee";
	}

	@GetMapping("/employeeForm")
	public String showEmployeeForm(Model theModel) {

		Employee theEmployee = new Employee();
		/*Address theAddress = new Address();
		theEmployee.setHomeAddress(theAddress);*/
		theModel.addAttribute("employee", theEmployee);
		fillModelWithDefaultValues(theModel);
		
		return "employee-form";
	}

	@PostMapping("/saveEmployee")
	public String saveOrUpdateEmployee(@ModelAttribute("employee") @Validated Employee theEmployee,
			BindingResult result, Model theModel) {
		
		if (result.hasErrors()) {
			fillModelWithDefaultValues(theModel);
			return "employee-form";
		} else {
					if(theEmployee.getId() != null) {
						Employee tempEmployee = employeeService.getEmployee(theEmployee.getId());
						
						theEmployee.getProjects().addAll(tempEmployee.getProjects());
					}
	
					employeeService.saveEmployee(theEmployee);
			
			return "redirect:/employees/employee/" + theEmployee.getId();
		}		
	}

	@GetMapping("/employee/{id}/updateEmployee")
	public String updateEmployee(@PathVariable("id") Long employeeId, Model theModel) {
		
		theModel.addAttribute("employee", employeeService.getEmployee(employeeId));
		
		fillModelWithDefaultValues(theModel);

		return "employee-form";
	}

	@GetMapping("/employee/{id}/deleteEmployee")
	public String deleteEmployee(@PathVariable("id") Long employeeId, Model theModel) {

		employeeService.deleteEmployee(employeeId);

		return "redirect:/employees/";
	}
	
	
	
	/*@GetMapping("/employee/{id}/removeProject")
	public String removeProject(@PathVariable("id") Long employeeId, Model theModel) {
		
		Set<>
		theModel.addAttribute(n)
		theModel.addAttribute("employee_projects", employeeService.getEmployee(employeeId).getProjects());

		return "add-project-to-employee-form";
	}*/
	
	/*@PostMapping("/employee/{id}/addProject")
	public String addProject(@ModelAttribute Employee theEmployee) {

		theEmployee.getProjects().add(projectService.getProject(theEmployee.getProjectId()));
		employeeService.saveEmployee(theEmployee);

		return "redirect:/employees/employee/" + theEmployee.getId();
	}*/


	private void fillModelWithDefaultValues(Model theModel) {
		theModel.addAttribute("company_role", company_role);
		theModel.addAttribute("professional_experience", professional_experience);
		theModel.addAttribute("departments", departmentService.getDepartments());
		theModel.addAttribute("projects", projectService.getProjectsSet());

	}
}
