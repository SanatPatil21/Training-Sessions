package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {
	
	//Basically when any request comes to the / (root path), load the abc.html
	@RequestMapping("/")
	public String getFirstPage() {
		return "home.html";
	}
	
	@RequestMapping("signin")
	public String getLoginPage() {
		return "login.html";
	}

	@RequestMapping("/verify")
	public String verifyUser(String user, String pwd, HttpSession session) {
		session.setAttribute("uname", user);
		if(user.equalsIgnoreCase(pwd))
			return "welcome.jsp";
		else
			return "failure.html";
	}
	
	@RequestMapping("/verifymv")
	public ModelAndView verifyUserMv(String user, String pwd) {
		
		ModelAndView mv = new ModelAndView();
		if(user.equalsIgnoreCase(pwd)) {
			mv.addObject("uname",user);
			mv.setViewName("welcome.jsp");
		}else {
			mv.setViewName("failure.jsp");
		}
		
		return mv;
			
		
	}
}
