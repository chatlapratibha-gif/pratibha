package com.assignment.mailbox.controllers;

import java.util.Date;

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

import com.assignment.mailbox.model.User;
import com.assignment.mailbox.model.UserLogin;
import com.assignment.mailbox.services.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userServices;
	@GetMapping("/")
	public String userHome(Model model)
	{
		
		model.addAttribute("user", new UserLogin());
		return "user";
	}
	
	@PostMapping("/userlogin")
	public String studentLogin(@ModelAttribute("user") UserLogin userLogin,BindingResult result, Model model,HttpSession session)
	{
	
		if(result.hasErrors())
		{
			return "user";
		}
		else {
		boolean status = userServices.login(userLogin);
		if(status)
		{
			session.setAttribute("username",userLogin.getUsername());
			return "userhome";
		}
		else
		{
			model.addAttribute("message","Invalid Username OR password");
			return "user";
		}
		
		}
	}
	
	
	@GetMapping("/register")
	public String userRegisterForm(Model model)
	{
		User user = new User();
		model.addAttribute("userreg", user);
		
		return "userregistration";
	}

	
	@PostMapping("/userregistration")
	public String registerStudent(@Valid @ModelAttribute("userreg") User user,BindingResult result,Model model)
	{
		if(result.hasErrors())
		{
			return "userregistration";
		}
		
		else {
			UserLogin stdlogin = new UserLogin();
			model.addAttribute("user",stdlogin);
		
		int res = userServices.createUser(user);
		if(res==0)
		{
			model.addAttribute("message", user.getFirstname().concat(user.getLastname()).toUpperCase()+" You are already registered");
		
		
		}
		else if(res==1)
		{
			model.addAttribute("message", user.getFirstname().concat(user.getLastname()).toUpperCase()+"Congrats your registration is successfull");
		
		
		}
		else
		{
			model.addAttribute("message", "Some thing went wrong");
		
		}
		
		
		return "user";
		}
		

	
	}
}