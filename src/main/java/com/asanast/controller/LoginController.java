package com.asanast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asanast.model.UserCredentials;

@Controller
public class LoginController {
	
	@GetMapping("/")
	public String redirectToLogin() {
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String showLoginForm(@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout,
			Model model) {
		model.addAttribute("userCredentials", new UserCredentials());
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		return "login";
	}
	
	@PostMapping("/logincheck")
	public String loginCheck(@ModelAttribute(name="userCredentials") UserCredentials userCredentials) {
		if(userCredentials.getUsername().equals("user") && userCredentials.getPassword().equals("user")) {
			return "contacts";
		}
		return "redirect:/login?error";
	}

}
