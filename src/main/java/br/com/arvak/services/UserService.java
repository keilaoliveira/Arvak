package br.com.arvak.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.arvak.security.UserSS;

public class UserService {
	
	public static UserSS authenticated() {
		try {
			// Retorna o usuário Logado
		return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}

}
