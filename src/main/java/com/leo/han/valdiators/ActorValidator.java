package com.leo.han.valdiators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.leo.han.beans.Actor;

@Component
public class ActorValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		 return Actor.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		Actor actor = (Actor)target;
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "first_name", "first_name_error", "default_First name is empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "last_name", "last_name_error", "default_Last name is empty");		

	}

}
