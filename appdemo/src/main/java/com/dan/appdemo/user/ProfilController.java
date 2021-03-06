package com.dan.appdemo.user;

import java.util.Locale;

import javax.ws.rs.GET;
import javax.ws.rs.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dan.appdemo.utilities.UserUtilities;
import com.dan.appdemo.validators.ChangePasswordValidator;
import com.dan.appdemo.validators.EditUserProfileValidator;

@Controller

public class ProfilController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messageSource;

	@GET
	@RequestMapping(value = "/profil")
	
	public String showUserProfilePage(Model model) {
		String username = UserUtilities.getLoggedUser();

		User user = userService.findUserByEmail(username);

		int RoleNumber = user.getRoles().iterator().next().getId();

		user.setRoleNumber(RoleNumber);
		model.addAttribute("user", user);

		return "profil";

	}

	@GET
	@RequestMapping(value = "/editpassword")
	@Secured(value = {"ROLE_USER", "ROLE_ADMIN"})
	public String editUserPassword(Model model) {
		String username = UserUtilities.getLoggedUser();
		User user = userService.findUserByEmail(username);
		model.addAttribute("user", user);
		return "editpassword";
	}

	@POST
	@RequestMapping(value = "/updatepassword")
	public String changeUserPassword(User user, BindingResult result, Model model, Locale locale) { // rejestracja
																									// uzytkowanika, 4 argumenty w metodzie
																								
		String returnPage = null;

		new ChangePasswordValidator().validate(user, result);
		new ChangePasswordValidator().checkPasswords(user.getNewPassword(), result);// sprawdz czy podalismy hasło,
																					// jeżeli pole nie jest puste

		if (result.hasErrors()) {
			returnPage = "editpassword";
		} else {
			userService.updateUserPassword(user.getNewPassword(), user.getEmail());
			returnPage = "editpassword";
			model.addAttribute("message", messageSource.getMessage("passwordChange.success", null, locale));
		}
		return returnPage;
	}

	@GET
	@RequestMapping(value = "/editprofil" )
	public String changeUserData (Model model) {
		
		String username = UserUtilities.getLoggedUser();
		User user = userService.findUserByEmail(username);
		model.addAttribute("user", user);
		return "editprofil";
		
	}
	
	@POST
	@RequestMapping(value="/updateprofil")
	public String changeUserDataAction(User user, BindingResult result, Model model, Locale locale) {
		String returnPage = null;
		new EditUserProfileValidator().validate(user, result);
		if(result.hasErrors()) {
			returnPage ="editprofil";
		}else{
			
			userService.updateUserProfile(user.getName(), user.getLastName(), user.getEmail(), user.getId());
			model.addAttribute("message", messageSource.getMessage("profilEdit.succes", null, locale));
			returnPage = "afteredit";
			
		}
		
		return returnPage;
		
		
	}
	
	
}
