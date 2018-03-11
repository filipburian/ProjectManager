package com.employee.manager.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.manager.domain.Department;
import com.employee.manager.domain.Employee;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<String> getDepartmentNames() {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<String> query = session.createQuery("select departmentName from Department", String.class);
		
		List<String> departmentNames = query.getResultList();
		return departmentNames;
	}

	@Override
	public List<Department> getDepartments() {
		Session session = sessionFactory.getCurrentSession();
		
		Query<Department> query = session.createQuery("from Department order by departmentName", Department.class);
		
		List<Department> departments = query.getResultList();
		
		return departments;
	}
	
	@Override
	public Department getDepartment(Long theId) {
		Session session = sessionFactory.getCurrentSession();
		
		return session.get(Department.class, theId);
	}

	@Override
	public void deleteDepartment(Long theId) {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery("delete from Department where id=:departmentId");
		query.setParameter("departmentId", theId);
		query.executeUpdate();
		
	}

	@Override
	public void saveDepartment(Department theDepartment) {
		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(theDepartment);
		
	}


}
