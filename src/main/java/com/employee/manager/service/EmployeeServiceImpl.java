package com.employee.manager.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.manager.domain.Employee;
import com.employee.manager.domain.Project;
import com.employee.manager.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
	{
	    Map<Object, Boolean> map = new ConcurrentHashMap<>();
	    return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
	}

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public List<Employee> getEmployees() {

		return employeeRepository.getEmployees();
	}

	@Transactional
	public Employee getEmployee(Long theId) {
		
		return employeeRepository.getEmployee(theId);
	}
	
	@Transactional
	public Map<Long, String> getEmployeesIdMap() {
		
		Map<Long, String> employeesIdMap =
				employeeRepository.getEmployees().stream().filter(distinctByKey(Employee::getId))
				.collect(Collectors.toMap(Employee::getId, Employee::getFullName));
		
		employeesIdMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue)->oldValue, LinkedHashMap::new));
		
	
			
		return employeesIdMap;	
	}

	@Transactional
	public void deleteEmployee(Long theId) {
		employeeRepository.deleteEmployee(theId);

	}
	@Transactional
	public void saveEmployee(Employee employee) {
		employeeRepository.saveEmployee(employee);

	}

	@Transactional
	public List<Employee> getEmployeesByLastName(String lastName) {
		
		return employeeRepository.getEmployeesByLastName(lastName);
	}



}
