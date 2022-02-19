package br.com.estoqueartesanart.mvc.estoqueartesanart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class LoginController {

	
	@GetMapping("/login")
	public String Login() {
		return "login";
	}
	
	@GetMapping("/entrar")
	public String Entrar() {
		return "entrar";
	}
	
	
}
