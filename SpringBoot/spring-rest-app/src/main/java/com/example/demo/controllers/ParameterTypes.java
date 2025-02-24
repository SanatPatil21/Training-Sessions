package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Person;

@RestController
public class ParameterTypes {
	
	@GetMapping("/query")
	public String queryParamDemo(@RequestParam("name")String name, @RequestParam("age")int age) {
		System.out.println(" **** Query Paramater ****");
		System.out.println(" Name:  "+name);
		System.out.println(" Age:  "+age);
		return "Name: "+name+" Age: "+age;	
	}
	
	@GetMapping("/path/{name}/{age}")
	public String pathParamDemo(@PathVariable String name, @PathVariable int age) {
		System.out.println(" **** Path Paramater ****");
		System.out.println(" Name:  "+name);
		System.out.println(" Age:  "+age);
		return "Name: "+name+" Age: "+age;	
		
	}

	
	
	@GetMapping("/body")
	public String bodyParamDemo(@RequestBody Person p) {
		
		System.out.println(" **** Body Paramater **** ");
		System.out.println(" Name:  "+p.getName());
		System.out.println(" Age:  "+p.getAge());
		return "Name: "+p.getName()+" Age: "+p.getAge();		
	}
	
	@GetMapping(path = "/persons", produces = "application/xml")
	public List<Person> getPersons(){
		List<Person> list = new ArrayList<Person>();
		
		
		list.add(new Person("Pooja",34));
		list.add(new Person("Duuja",24));
		list.add(new Person("Sooja",32));
		list.add(new Person("Bhulja",23));
		list.add(new Person("Suja",36));
		
		return list;
		
	}
}
