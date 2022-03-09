package com.in28minutes.rest.webservices.restfulwebservices.emp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@Repository
@Transactional
public class EmployeeService {

	@PersistenceContext
	public EntityManager entityManager;

	public Employee insert(Employee employee) {
		return entityManager.merge(employee);
	}

	public List<Employee> findAll() {
		TypedQuery<Employee> namedQuery = entityManager.createNamedQuery("find_all_emp", Employee.class);
		return namedQuery.getResultList();
	}

	public Employee deleteById(int id) {
		Employee employee = findById(id);
		entityManager.remove(employee);
		return employee;
	}

	public Employee findById(int id) {
		Employee employee = entityManager.find(Employee.class, id);

		return employee;
	}

}
