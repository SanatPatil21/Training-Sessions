package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Employee;
import com.example.demo.repos.EmpDao;


@RestController
public class EmployeeService {

	@Autowired
	EmpDao dao;
	

	public Iterable<Employee> getEmployees() {
		return dao.findAll();
	}

	public String addEmployees(Employee e) {
		
		if(dao.existsById(e.getEid()))
			return "Sorry Employee ID exists";
		dao.save(e);
		return "Added Employee SuccessFully";
		
	}
	

	public String updateEmployee( Employee e, int id) {
		
		if(!dao.existsById(id))
			return "Sorry! No Employee with this ID Exists";
		dao.save(e);
		return "Employee Updated ";
	}
	
	

	public String removeEmployee( int id) {
		if(!dao.existsById(id))
			return "Sorry! No Employee with this ID Exists";
		dao.deleteById(id);
		return "Employee Deleted ";
			
	}
	
	

	public List<Employee> getEmployeesByDesig(String desig){
		return dao.getByDesignation(desig);	
	}

	public List<Employee> getEmployeeAbove(int age){
		return dao.findByAgeGreaterThan(age);	
	}

	public List<Employee> getEmployeeBelow(int age){
		return dao.findByAgeLessThan(age);	
	}
	

	public List<Employee> getCustomQuery(String desig){
		return dao.myCustomQuery(desig);
	}
	
	
	
	

}
