package com.leo.han.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leo.han.beans.User;
import com.leo.han.service.UserService;
import com.leo.han.valdiators.UserValidator;


@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private UserValidator userValidator;
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLogin(){
		
		return "login";
	}
	
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String showLogout(){
		
		return "home";
	}
	
	
	
	@RequestMapping(value="/adduser", method=RequestMethod.GET)
	public String addUserGet(Model model){
		model.addAttribute("user", new User());
		return "adduser";
	}
	
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public String addUserPost(User user, BindingResult bindingResult ){
		userValidator.validate(user, bindingResult);
		
		if(bindingResult.hasErrors()){
			
			return "adduser";
		}
		
		if(userService.isUserExist(user)){
			bindingResult.rejectValue("username", "duplicate_user", "duplicated user name");
			return "adduser";
		}
		
		user.setEnabled(true);
		userService.createUser(user);
		
		return "useradded";
	}
	

}
