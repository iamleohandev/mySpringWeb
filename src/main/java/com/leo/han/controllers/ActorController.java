package com.leo.han.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leo.han.beans.Actor;
import com.leo.han.service.ActorService;
import com.leo.han.valdiators.ActorValidator;

@Controller
public class ActorController {
	
	@Autowired
	private ActorService service;
	
	@Autowired
	private ActorValidator actorValidator;
	
	
	@RequestMapping(value="/actors", method =RequestMethod.GET )
	public String showDetails(Model model){
		
		
		List<Actor> actors = service.retrieveAll();
		
		model.addAttribute("actors", actors);
		model.addAttribute("title", "Show all actors");
		
		return "actors";
	}
	
	
	@RequestMapping(value="/addactor", method =RequestMethod.GET )
	public String addActor(Model model){
		
		model.addAttribute("actor", new Actor());
		
		return "addactor";
	}
	
	@RequestMapping(value="/addactor", method =RequestMethod.POST )
	public String addActorResult(Model model, Actor actor,  BindingResult bindingResult){
		
		actorValidator.validate(actor, bindingResult);
		
		
		if(bindingResult.hasErrors()){
			
			return "addactor";
			
		}
//		service.addActor(actor);
		
		return "addactorresult";
	}
	
	

}
