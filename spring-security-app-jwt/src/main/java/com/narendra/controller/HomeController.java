package com.narendra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.narendra.entity.AuthenticationRequest;
import com.narendra.util.JwtUtils;

@RestController
public class HomeController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtils jwtUtils;

	// It authenticates user and generates token
	// http://localhost:8080/authenticate
	@PostMapping("/authenticate")
	public ResponseEntity<String> authentication(@RequestBody AuthenticationRequest request) {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(request.getUsername());
		}

		// return jwtUtils.generateToken(request.getUsername());
		return new ResponseEntity<String>(jwtUtils.generateToken(request.getUsername()), HttpStatus.OK);

	}

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
