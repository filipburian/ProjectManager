package com.employee.manager.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.employee.manager.domain.Employee;

@Component
public class EmployeeFormValidator implements Validator {

	@Autowired
	@Qualifier("emailValidator")
	EmailValidator emailValidator;
	
	@Override
	public boolean supports(Class<?> theClass) {
		
		return Employee.class.equals(theClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Employee employee = (Employee) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "NotEmpty.employee-form.firstName");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "NotEmpty.employee-form.lastName");
	/*	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty.employee-form.email");*/
		/*ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty.employee-form.address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty.employee-form.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword","NotEmpty.employee-form.confirmPassword");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", "NotEmpty.employee-form.sex");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "NotEmpty.employee-form.country");*/

		if(!emailValidator.valid(employee.getEmail())){
			errors.rejectValue("email", "Pattern.employee-form.email");
		}

		/*if(employee.getFirstName()==null || employee.getFirstName().isEmpty()){
			errors.rejectValue("firstName", "NotEmpty.employee-form.firstName");
		}
		if(employee.getLastName()==null || employee.getLastName().isEmpty()){
			errors.rejectValue("lastName", "NotEmpty.employee-form.lastName");
		}*/

		/*if(employee.getCountry().equalsIgnoreCase("none")){
			errors.rejectValue("country", "NotEmpty.employee-form.country");
		}

		if (!employee.getPassword().equals(employee.getConfirmPassword())) {
			errors.rejectValue("confirmPassword", "Diff.employee-form.confirmPassword");
		}

		if (employee.getFramework() == null || employee.getFramework().size() < 2) {
			errors.rejectValue("framework", "Valid.employee-form.framework");
		}

		if (employee.getSkill() == null || employee.getSkill().size() < 3) {
			errors.rejectValue("skill", "Valid.employee-form.skill");
		}*/

	}

}
