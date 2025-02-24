package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employee;
import com.example.demo.services.EmployeeService;


@RestController
public class EmpController {
	
	@Autowired
	EmployeeService service;
	

	
	@GetMapping("/employees")
	public Iterable<Employee> getEmployees() {
		return service.getEmployees();
	}
	
	@PostMapping("/employees")
	public String addEmployees(@RequestBody Employee e) {
		
		return service.addEmployees(e);
		
	}
	
	@RequestMapping(path="/employees/{id}", method= {RequestMethod.PUT,RequestMethod.PATCH})
	public String updateEmployee(@RequestBody Employee e,@PathVariable int id) {
		
		return service.updateEmployee(e, id);
	}
	
	
	@DeleteMapping("/employees/{id}")
	public String removeEmployee(@PathVariable int id) {
		return service.removeEmployee(id);
			
	}
	
	
	@GetMapping("/employees/role")
	public List<Employee> getEmployeesByDesig(String desig){
		return service.getEmployeesByDesig(desig);
	}
	@GetMapping("/employees/above")
	public List<Employee> getEmployeeAbove(int age){
		return service.getEmployeeAbove(age);	
	}
	@GetMapping("/employees/below")
	public List<Employee> getEmployeeBelow(int age){
		return service.getEmployeeBelow(age);
	}
	
	@GetMapping("/employees/custom")
	public List<Employee> getCustomQuery(String desig){
		return service.getCustomQuery(desig);
	}
	
	
	
	

}
