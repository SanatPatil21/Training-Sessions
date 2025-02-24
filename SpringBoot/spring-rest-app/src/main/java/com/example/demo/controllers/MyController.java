package com.example.demo.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/")
	public String abc() {
		return "<h1>Welcome to REST API Application</h1>";
	}
	
	
	@GetMapping("/greet")
	public String getGreet() {
		return "<h3>Have a Good Day! from GET Mapping</h3>";
	}
	
	@PostMapping("/greet")
	public String postGreet() {
		return "<h3>Have a Good Day from POST Mapping!</h3>";
	}
	
	@PutMapping("/greet")
	public String putGreet() {
		return "<h3>Have a Good Day from PUT Mapping!</h3>";
	}
	
	
	@DeleteMapping("/greet")
	public String deleteGreet() {
		return "<h3>Have a Good Day from DELETE Mapping!</h3>";
	}
	
	
	@PatchMapping("/greet")
	public String patchGreet() {
		return "<h3>Have a Good Day from PATCH Mapping!</h3>";
	}
	

}
