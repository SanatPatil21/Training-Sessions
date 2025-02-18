package com.example.demo.models;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.db.DatabaseOperations;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class NetBankingController {
	
	 private DatabaseOperations dbOps = new DatabaseOperations();


	@RequestMapping("/")
	public String getHomePage() {
		return "home.html";
	}
	
	@RequestMapping("/login")
	public String getLogin() {
		return "login.jsp";
	}
	
	@RequestMapping("/signup")
	public String getSignup() {
		return "signup.jsp";
	}
	
	@RequestMapping("/check_cid")
	public String checkCustomerID(@RequestParam("cid") String cid, Model model) {
	    boolean exists = dbOps.checkCid(Integer.parseInt(cid));
	    
	    model.addAttribute("cidValue", cid); // Retain CID Input
	    
	    if (exists) {
	        model.addAttribute("error", "Customer ID already exists! Choose another.");
	    } else {
	        model.addAttribute("success", "Customer ID is available.");
	        model.addAttribute("cidValid", cid); 
	    }
	    
	    return "signup"; 
	}
	
	@RequestMapping("/submit_signup")
	public String handleSignup(@RequestParam("cid") String cid,@RequestParam("cname") String cname, @RequestParam("pwd") String pwd, Model model) {
		
		boolean registered = dbOps.registerUser(Integer.parseInt(cid),cname, pwd);
		
		if (registered) {
            model.addAttribute("message", "Signup successful! You can now login.");
            return "signup_success.jsp";
        } else {
            model.addAttribute("message", "Signup failed! Try again.");
            return "signup.jsp";
        }
	}
	
	
	@RequestMapping("/submit_login")
    public String submitLogin(@RequestParam("cid") String cid, @RequestParam("pwd") String pwd, Model model, HttpSession session) {
        String name = dbOps.validateUser(Integer.parseInt(cid), pwd);

        if (name != null) {
            session.setAttribute("customerId", cid);
            session.setAttribute("customerName", name);
            model.addAttribute("cid", cid);
            model.addAttribute("name", name);
            return "login_success.jsp"; 
        } else {
            model.addAttribute("loginError", "Invalid Customer ID or Password.");
            return "login.jsp"; 
        }
    }
	
	@RequestMapping("/logout")
	public String handleLogout(HttpSession session) {
		session.removeAttribute("cid");
		session.removeAttribute("name");
		
		return "home.html";
		
	}

}
