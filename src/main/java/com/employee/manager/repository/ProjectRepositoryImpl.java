package com.employee.manager.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.manager.domain.Department;
import com.employee.manager.domain.Employee;
import com.employee.manager.domain.Project;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
	{
	    Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Project> getProjects() {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<Project> query = session.createQuery("from Project order by name", Project.class);
		
		List<Project> projects = query.getResultList();
		
		return projects;
	}
	
	public Project getProject(Long theId) {
		Session session = sessionFactory.getCurrentSession();
				
		return session.get(Project.class, theId);
	}

	@Override
	public void deleteProject(Long theId) {
		Session session = sessionFactory.getCurrentSession();
		
		@SuppressWarnings("unchecked")
		Query<Employee> query = session.createQuery("delete from Project where id=:projectId");
		query.setParameter("projectId", theId);
		query.executeUpdate();
	}

	@Override
	public void saveProject(Project theProject) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(theProject);
	}

	

	@Override
	public List<String> getProjectNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
