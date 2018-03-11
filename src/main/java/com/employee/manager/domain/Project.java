package com.employee.manager.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="project")
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name = "name")
	private String projectName;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.DETACH})
	@JoinColumn(name="department_id")
	private Department department;
	
	@Column(name="beginning_date")
	@Temporal(TemporalType.DATE)
	private Date beginningDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@Column(name ="info", length = 65535, columnDefinition="Text")
	private String info;
	
	/*private Employee manager;*/
	
	/*@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(fetch= FetchType.EAGER,
		cascade= {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@Cascade({ org.hibernate.annotations.CascadeType.SAVE_UPDATE})
	@JoinTable(name="employee_project", joinColumns=@JoinColumn(name="project_id"),
	inverseJoinColumns=@JoinColumn(name="employee_id"))*/
	@ManyToMany(fetch= FetchType.EAGER, mappedBy="projects", 
			cascade={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH,CascadeType.DETACH})
	private Set<Employee> employees = new HashSet<>();
	
	@Transient
	private Long departmentId;
	
/*	public void addEmployee(Employee theEmployee) {
		
		if(employees ==null) {
			employees = new HashSet<>();
		}
		employees.add(theEmployee);
		//theEmployee.addProject(this);
	}*/
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Date getBeginningDate() {
		return beginningDate;
	}

	public void setBeginningDate(Date beginningDate) {
		this.beginningDate = beginningDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
	public void removeEmployees(Set<Employee> theEmployees) {
		
		for(Employee employee : theEmployees) {
			employee.getProjects().remove(this);
		}
		this.employees.removeAll(theEmployees);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return id.toString();
	}

	

}
