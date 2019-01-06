package com.dan.appdemo.mainController;

import javax.ws.rs.GET;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorPageController implements ErrorController{

	public String getErrorPath() {

		return "/error";

	}

	@GET
	@RequestMapping(value = "/error")
	public String showErrorPage() {

		return "error";

	}

}
