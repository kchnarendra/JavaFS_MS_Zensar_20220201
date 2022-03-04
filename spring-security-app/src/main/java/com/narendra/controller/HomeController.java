package com.narendra.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping()
	public String home() {
		return "<h1>Welcome Home!!!";
	}
	
	@GetMapping("/user")
	public String user() {
		return "<h1>Welcome User!!!";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "<h1>Welcome Admin!!!";
	}
}
