package com.dan.appdemo.utilities;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserUtilities {

	public static String getLoggedUser() {

		String username = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		if (!(auth instanceof AnonymousAuthenticationToken)) { // jeżeli nie jest przechowowane coś co ma anonymousa, to
																// pobieramy z contextu nazwę
																// zalogowanego uzytkowanika inczej zwróci nam nulla
			username = auth.getName();

			return username;

		}

		return username;

	}

}
