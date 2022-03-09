package com.in28minutes.rest.webservices.restfulwebservices.hellobean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@GetMapping(path="/home")
	public String helloWorld() {
		
		return "Hello Developer";
	}
	
	@GetMapping(path="/hellobean")
	public HelloBean helloBean() {
		
		return new HelloBean("Be The One !");
	}

	@GetMapping(path="/home/path-variable/{name}")
	public HelloBean helloBeanPathVariable(@PathVariable String name) {
		
		return new HelloBean(String.format("Be The One !,%s",name));
	}
}
