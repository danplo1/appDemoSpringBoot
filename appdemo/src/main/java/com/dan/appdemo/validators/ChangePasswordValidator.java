package com.dan.appdemo.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.dan.appdemo.constants.AppDemoConstants;
import com.dan.appdemo.user.User;
import com.dan.appdemo.utilities.AppDemoUtils;

public class ChangePasswordValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return User.class.equals(cls);

	}

	@Override
	public void validate(Object obj, Errors errors) {

		@SuppressWarnings("unused")
		User u = (User) obj;

		ValidationUtils.rejectIfEmpty(errors, "new Password", "error.userPassword.empty");

	}

	public void checkPasswords(String newPass, Errors errors) {
		// metoda z dwoma argumentami: nowe hasło na formularzu i to co wróci w przypadku błędów

		if (!newPass.equals(null)) {
			boolean isMatch = AppDemoUtils.checkEmailOrPassword(AppDemoConstants.passwordPattern, newPass);
			if (!isMatch) {
				errors.rejectValue("newPassword", "error.userPasswordIsNotMatch");
			}

		}

	
	}

}
