package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Emp;
import com.example.demo.repositories.EmpDao;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmpRestController {
	
	@Autowired
	EmpDao empRepo;
	
	
	@GetMapping("/employees")
	public List<Emp> getEmployees()
	{
		return empRepo.findAll();
	}
	
	
	@GetMapping("/employees/{id}")
	public Optional<Emp> getEmployeeById(@PathVariable int id)
	{
		return empRepo.findById(id);
	}
	
	@PostMapping("/employees")
	public Emp insertEmployee(@RequestBody Emp e) {
		return empRepo.save(e);
	}
	
	@PutMapping("/employees")
	public Emp updateEmployee(@RequestBody Emp e) {
		return empRepo.save(e);
	}
	
	@DeleteMapping("/employees/{id}")
	public void deleteEmployee(@PathVariable int id) {
		empRepo.deleteById(id);
	}
}
