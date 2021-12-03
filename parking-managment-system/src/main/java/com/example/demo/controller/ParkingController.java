package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
