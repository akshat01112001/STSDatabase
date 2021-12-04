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
		if((userDetails.getPassword()).compareTo(userDetails.getConfPassword())==0)
		{
			detailsService.saveUserDetails(userDetails);
			return "redirect:/login";
		}
		else
			return "redirect:/register";
	}
	
	@GetMapping("/login")
	public String Login(Model model) {
		UserDetails userDetails=new UserDetails();
		model.addAttribute("userDetails", userDetails);
		return "Login";
	}
	
	@GetMapping("/dashboard")
	public String Dashboard() {
		return "Dashboard";
	}
	
	@PostMapping("/processDetails")
	public String Dashboard(@ModelAttribute("UserDetails") UserDetails userDetails)
	{
		if(detailsService.findUser(userDetails)==true && (userDetails.getUsername()).compareTo("admin")==0)
		return "redirect:/";
		else if(detailsService.findUser(userDetails)==true)
		return "redirect:/dashboard";
		else
		return "redirect:/login";
	}
}
