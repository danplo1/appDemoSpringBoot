package com.dan.admin;

import javax.ws.rs.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPageController {
	
	@GET
	@RequestMapping(value ="/admin")
	
	public String openAdminMainPage() {
		
		return "admin/admin";
	}
	

}
