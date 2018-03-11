package com.employee.manager.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.manager.domain.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Employee> getEmployees() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Employee> query = session.createQuery("from Employee order by lastName", Employee.class);
		
		List<Employee> employees = query.getResultList();
		
		return employees;
	}

	public Employee getEmployee(Long theId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Employee.class, theId);
	}
	
	public List< Employee> getEmployeesByLastName(String lastName) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Employee> query = session.createQuery("from Employee where lastName=:lastName");
		
		query.setParameter("lastName", lastName);
		
		return query.getResultList();
	}

	public void deleteEmployee(Long theId) {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
		query.setParameter("employeeId", theId);
		query.executeUpdate();
	}

	public void saveEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(employee);
	}


}
