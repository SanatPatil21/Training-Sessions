package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.models.Address;
import com.example.demo.models.Employee;
import com.example.demo.models.Student;

@Configuration
public class MyBeanJavaConfig {
	
	@Bean("emp")
	public Employee getEmployeeObject() {
//		return new Employee("Sanat",22,25000,"Tester",new Address());
		return new Employee("Sanat", 21, 35000, "Dev Ops", getAddress());
	}
	
	@Bean("addr")
	public Address getAddress() {
		return new Address("Maharashtra", "Mumbai",400055);
	}
	
	@Bean("emp_s")
	public Employee getEmployeeWithSetter() {
		Employee e = new Employee();
		e.setName("Madhav");
		e.setAge(21);
		e.setSalary(24000);
		e.setDesignation("Manager");
		e.setAddress(getAddressThrSetter());
		return e;
		
	}
	
	
	@Bean("addr_s")
	public Address getAddressThrSetter() {
		Address a1 = new Address();
		a1.setCity("Pune");
		a1.setPin(400054);
		a1.setState("Maharashtra");
		return a1;
	}
	


}
