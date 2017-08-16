package com.asanast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asanast.constant.ViewConstant;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String showLoginForm(@RequestParam(name="error", required=false) String error,
			@RequestParam(name="logout", required=false) String logout,
			Model model) {
		model.addAttribute("logout", logout);
		model.addAttribute("error", error);
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {
		return "redirect:/contacts/showcontacts";
	}

}
