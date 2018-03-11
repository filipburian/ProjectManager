package com.employee.manager.utils;

public enum ProfessionalExperience {
	JUNIOR("Junior"),
	REGULAR("Regular"), 
	SENIOR("Senior");
	
	private String experience;
	
	private ProfessionalExperience(String experience) {
		
		this.experience = experience;
	}
	
	public String toString() {
		return experience;
		
	}
	
	
}
