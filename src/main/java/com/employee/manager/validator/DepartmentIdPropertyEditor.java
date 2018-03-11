package com.employee.manager.validator;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.employee.manager.domain.Department;
import com.employee.manager.service.DepartmentService;

@Component
public class DepartmentIdPropertyEditor extends PropertyEditorSupport {

	@Autowired
	DepartmentService departmentService;

	@Override
	public void setAsText(String departmentId) throws IllegalArgumentException {
		if (StringUtils.hasText(departmentId)){
			try {
				Department department = new Department();
				department = departmentService.getDepartment(Long.parseLong(departmentId));
				this.setValue(department);
			}catch(NumberFormatException e) {
				this.setValue(null);
			}
		} else {
			this.setValue(null);
		}
	}

	@Override
	public String getAsText() {
		Department dep = (Department) getValue();
		if (dep != null) {
			return dep.getDepartmentName();
		} else {
			return "";
		}

	}

}
