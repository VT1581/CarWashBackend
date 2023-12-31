package com.na.userAuthentication.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {
	
	
	
	@GetMapping("/all")
	public String allAccess() {
		return "Public Content.";
	}
	
	@GetMapping("/user")
	@PreAuthorize("hasRole('CARWASHER') or hasRole('ADMIN') or hasRole('CUSTOMER')")
	public String userAccess() {
		return "customer Content.";
	}

	@GetMapping("/mod")
	@PreAuthorize("hasRole('CARWASHER')")
	public String moderatorAccess() {
		return "carwasher Board.";
	}

	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "admin Board.";
	}
}
