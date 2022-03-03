package com.narendra.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.narendra.entity.User;

@Controller
public class SampleController {

	private static List<User> users = new ArrayList<User>();
	static {
		users.add(new User("Tom", "New York"));
		users.add(new User("Jerry", "Washington"));
		users.add(new User("Ivan", "London"));
	}
	
	@GetMapping(value="contactus")
	public String contactUs1(Model model) {
		model.addAttribute("users", users);
		return "contactus";
	}
	
	@GetMapping(value="user")
	public ModelAndView contactUs() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		user.setName("Narendra");
		user.setLocation("Hyderabad");
		modelAndView.addObject("user", user);
		return modelAndView;
	}
}