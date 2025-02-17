package com.example.demo.models.lappy;

import org.springframework.stereotype.Component;

@Component(value = "mac")
public class MacBook implements Laptop {
	public String toString() {
		return "You got a MacBook";
	}

}
