package com.zhuo.travel.validator;



import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.zhuo.travel.model.User;


public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "validate.userName", "Please Enter Username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "validate.email", "Please Enter Your email Address");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "validate.password", "Please Enter Password");
	}

}
