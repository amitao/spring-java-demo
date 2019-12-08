package com.amie.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amie.demo.domain.User;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(Model model) {
		// formData key access in User object
		model.addAttribute("formData", new User());
		return "index";
	}
	
	// URL create is where data is submitted to
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	// show form input data in html - add object parameters
	public String submitForm(User user) {
		// after form is submitted it redirects to dataResult.html in templates
		return "dataResult";
	}
	
	
}
