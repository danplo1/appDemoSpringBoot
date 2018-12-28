package com.dan.appdemo.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dan.appdemo.constants.AppDemoConstants;
import com.dan.appdemo.user.User;
import com.dan.appdemo.utilities.AppDemoUtils;

public class UserRegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User u = (User) obj;

		ValidationUtils.rejectIfEmpty(errors, "name", "error.userName.empty");
		ValidationUtils.rejectIfEmpty(errors, "lastName", "error.userLastName.empty");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.userEmail.empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "error.userPassword.empty");

		if (!u.getEmail().equals(null)) {
			boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.emailPattern, u.getEmail());
			if (!isMatch) {
				errors.rejectValue("email", "error.userEmailIsNotMatch");
			}
		}

		if (!u.getPassword().equals(null)) {
			boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.passwordPattern, u.getPassword());
			if (!isMatch) {
				errors.rejectValue("password", "error.userPasswordIsNotMatch");
			}
		}

	}

	public void validateEmailExist(User user, Errors errors) {
		if (user != null) {
			errors.rejectValue("email", "error.userEmailExist");
		}
	}

}
