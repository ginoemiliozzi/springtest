package com.gpl.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gpl.backendninja.constant.ViewConstant;

@Controller
public class LoginController {


	
	@GetMapping("/login")
	public String showLoginForm(Model model,
			@RequestParam(name="error", required=false) String error) {
		model.addAttribute("error", error);
		return ViewConstant.LOGIN;
	}
	
	@GetMapping({"/loginsuccess", "/"})
	public String loginCheck() {		
			return "redirect:/contacts/showcontacts";

		
		
	}
}
