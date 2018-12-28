package com.dan.appdemo.user;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

	
	@GET //odebranie danych
	@RequestMapping(value = "/register") //obsługa wywołania
	public String registerForm (Model model) {
		
		User u = new User();
		model.addAttribute("user", u);
		return "registred";
		
	}

}
