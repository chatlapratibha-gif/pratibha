package com.assignment.mailbox.controllers;

import javax.servlet.http.HttpSession;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.assignment.mailbox.model.Admin;
import com.assignment.mailbox.services.AdminService;

@Controller
@RequestMapping(value ="/admin")
public class Admincontroller {
	
	@Autowired
	private AdminService adminServices;
	
	
	@GetMapping("/")
	public String adminLogin(Model model)
	{
	  Admin admin = new Admin();
	  model.addAttribute("admin", admin);
	  return "admin";
	}

	
	@PostMapping("/adminlogin")
	public String VerifyAdminLogin(@Valid @ModelAttribute("admin") Admin admin, BindingResult result, Model model, HttpSession session)
	{
		
		if(result.hasErrors())
		{
			return "admin";
		}
		else 
		{
		
		if(adminServices.login(admin))
		{
			session.setAttribute("adminusername", admin.getUsername());
			
			return "adminhome";
		}
		
		model.addAttribute("message", "Invalid UserName or Password");
		
		return "failure";
		}
	}
}
