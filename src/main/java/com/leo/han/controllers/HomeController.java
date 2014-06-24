package com.leo.han.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String goHome(){
		
		return "home";
	}
	
	
	@RequestMapping(value="/jquery", method = RequestMethod.GET)
	public String goJquery(){
		
		return "jquery";
	}
}
