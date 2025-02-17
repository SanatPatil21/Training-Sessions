package com.example.demo.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Address {
	private String state;
	private String city;
	private int pin;
	
	public Address(){
		System.out.println("Address Object Created");
	}
	
	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + ", pin=" + pin + "]";
	}
	
	

}
