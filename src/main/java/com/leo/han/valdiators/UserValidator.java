package com.leo.han.valdiators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.leo.han.beans.User;

@Component
public class UserValidator implements Validator {
	
	
	private static final int MINIMUM_USERNAME =2;
	private static final int MAXIMUM_USERNAME =8;
	
	private static final int MINIMUM_PASSWORD =2;
	private static final int MAXIMUM_PASSWORD =8;
	
	private static final int MINIMUM_AUTHORITY =2;
	private static final int MAXIMUM_AUTHORITY =8;
	

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		User user = (User)target;
		
		
		if(user.getUsername()==null || "".equals(user.getUsername())){
			errors.rejectValue("username", "username_empty", "username is empty");		
		}else{
			
			int length = user.getUsername().length();
			
			if(length<MINIMUM_USERNAME || length > MAXIMUM_USERNAME){
				errors.rejectValue("username", "username_size", "username size is wrong");
			}
		}
		
		
		if(user.getPassword()==null || "".equals(user.getPassword())){
			errors.rejectValue("password", "password_empty", "password is empty");		
		}else{
			
			int length = user.getPassword().length();
			
			if(length<MINIMUM_PASSWORD || length > MAXIMUM_PASSWORD){
				errors.rejectValue("password", "password_size", "password size is wrong");
			}
		}
		
		
		if(user.getAuthority() ==null || "".equals(user.getAuthority())){
			errors.rejectValue("authority", "authority_empty", "authority is empty");		
		}else{
			
			int length = user.getAuthority().length();
			
			if(length<MINIMUM_AUTHORITY || length > MAXIMUM_AUTHORITY){
				errors.rejectValue("authority", "authority_size", "authority size is wrong");
			}
		}
		

	}

}
