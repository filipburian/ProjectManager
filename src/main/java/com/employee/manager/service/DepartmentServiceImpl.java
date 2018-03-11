package com.employee.manager.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.employee.manager.domain.Department;
import com.employee.manager.domain.Project;
import com.employee.manager.repository.DepartmentRepository;


@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
	{
	    Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	public List<Department> getDepartments() {

		return departmentRepository.getDepartments();
	}
	@Transactional
	public Map<Long, String> getDepartmentsIdMap() {
		
		Map<Long, String> departmentsIdMap =
				departmentRepository.getDepartments().stream().filter(distinctByKey(Department::getDepartmentName))
				.collect(Collectors.toMap(Department::getId, Department::getDepartmentName));
		
		departmentsIdMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue)->oldValue, LinkedHashMap::new));
		
		System.out.println(departmentsIdMap);
		
		return departmentsIdMap;
	}

	@Transactional
	public Department getDepartment(Long theId) {
		
		return departmentRepository.getDepartment(theId);
	}

	@Transactional
	public void deleteDepartment(Long theId) {
		departmentRepository.deleteDepartment(theId);

	}
	@Transactional
	public void saveDepartment(Department department) {
		departmentRepository.saveDepartment(department);

	}

	@Transactional
	public List<String> getDepartmentNames() {
		
		List<String> departmentNames;
		List<Department> departments = departmentRepository.getDepartments();
		
		departmentNames=departments.stream().map(d->d.getDepartmentName()).collect(Collectors.toList());
		return departmentNames;
	}


}
