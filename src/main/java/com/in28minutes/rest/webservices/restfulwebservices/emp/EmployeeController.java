package com.in28minutes.rest.webservices.restfulwebservices.emp;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restfulwebservices.user.UserNotFoundException;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/show")
	public List<Employee> retriveAll() {

		return service.findAll();
	}

	@PostMapping("/add")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee emp) {
		Employee savedUser = service.insert(emp);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@GetMapping("/emp/{id}")
	public Employee retriveEmployee(@PathVariable int id) {

		Employee user = service.findById(id);
		if (user == null) {
			throw new UserNotFoundException("id :" + id);
		}
		return user;

	}
	
	@DeleteMapping("/emp/{id}")
	public void deleteUser(@PathVariable int id) {

		Employee user=service.deleteById(id);
		if(user==null) {
			throw new UserNotFoundException("id :"+id);
		}
		
		
	}

}
