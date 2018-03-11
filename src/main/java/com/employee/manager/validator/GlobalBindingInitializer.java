package com.employee.manager.validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.employee.manager.domain.Department;

@ControllerAdvice
public class GlobalBindingInitializer {

	@Autowired
	DepartmentIdPropertyEditor departmentIdPropertyEditor;
	
	@Autowired
	CustomProjectSetEditor customProjectSetEditor;
	
	@Autowired
	EmployeeFormValidator employeeFormValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), false));
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Department.class,"department", departmentIdPropertyEditor);
		
		//binder.setValidator(employeeFormValidator);
	}
	
}
