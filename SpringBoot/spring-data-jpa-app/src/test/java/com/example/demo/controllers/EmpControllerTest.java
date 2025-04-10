package com.example.demo.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.demo.services.EmployeeService;

@WebMvcTest(controllers = EmpController.class)
public class EmpControllerTest {
	
	@MockitoBean
	private EmployeeService empService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testGetEmployees(){
		try {
			mockMvc.perform(MockMvcRequestBuilders.get("/employees")).andExpect(MockMvcResultMatchers.status().is(200));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
