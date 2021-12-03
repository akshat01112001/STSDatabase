package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.UserDetails;
import com.example.demo.service.DetailsService;

@Controller
public class ParkingController {
	
	@Autowired
	private DetailsService detailsService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listDetails", detailsService.getAllUserDetailss());
		return "index";
	}
	
	@GetMapping("/register")
	public String Register(Model model) {
		UserDetails userDetails=new UserDetails();
		model.addAttribute("userDetails", userDetails);
		return "Register";
	}
	
	@PostMapping("/saveDetails")
	public String saveDetails(@ModelAttribute("UserDetails") UserDetails userDetails) {
		detailsService.saveUserDetails(userDetails);
		return "redirect:/";
	}
}
