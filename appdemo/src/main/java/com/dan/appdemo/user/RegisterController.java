package com.dan.appdemo.user;

import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dan.appdemo.validators.UserRegisterValidator;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	MessageSource messageSource; // pobiera komunikaty z meesage.properties komunikaty w kodzie Java

	@GET // odebranie danych
	@RequestMapping(value = "/register") // obsługa wywołania
	public String registerForm(Model model) {

		User u = new User();
		model.addAttribute("user", u);
		return "registred";
	}

	@POST
	@RequestMapping(value = "/adduser")
	public String registerAction(User user, BindingResult result, Model model, Locale locale) {

		String returnPage = null;

		User userExist = userService.findUserByEmail(user.getEmail());
		new UserRegisterValidator().validate(user, result);

		if (userExist != null) {
			result.rejectValue("email", messageSource.getMessage("error.userEmailExist", null, locale));
		}

		if (result.hasErrors()) {
			returnPage = "register";
		} else {
			
			userService.saveUser(user);
			model.addAttribute("message", messageSource.getMessage("user.register.success.email", null, locale));
			model.addAttribute("user", new User());
			returnPage = "index";
		}

		return returnPage;

	}

}
