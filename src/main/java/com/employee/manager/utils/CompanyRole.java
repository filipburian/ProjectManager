package com.employee.manager.utils;

public enum CompanyRole {
	ACCOUNTANT("Accountant"),
	DEPARTMENT_MANAGER("Accountant"),
	PROJECT_MANAGER("Accountant"),
	PROGRAMMER("Accountant"),
	NETWORK_ADMINISTRATOR("Accountant"),
	GRAPHIC_DESIGNER("Accountant");
	
	private final String role;
	
	private CompanyRole(final String role) {
		this.role = role;
		
	}
	
	/*public String getRole() {
		return role;
	}*/

	public String toString() {
		return role;
	}
}
