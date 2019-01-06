package com.dan.appdemo.mainController;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPageController {
	
	@GET
	@RequestMapping(value="/login") //wyświetla stronę logowania, resztą zajmuje się spring security
	public String showLoginPage() {
		
		return "login";
		
	}
	
	

}
