package com.employee.manager.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


	@RequestMapping("/")
	public String welcomePage(Model model) {

		model.addAttribute("greeting", "Welcome to the Employee Manager");
		model.addAttribute("tagline", "Application created to help you with employees management");

		return "home";
	}
}




