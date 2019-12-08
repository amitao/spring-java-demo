package com.amie.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amie.demo.domain.User;

@Controller
public class HomeController {
	
	// root URL that renders in the index.html
	// sends along User model with an empty object - key for the model is "formData" User object
	@RequestMapping("/")
	public String home(Model model) {
		// formData key that contains the user info in User object
		model.addAttribute("formData", new User());
		return "index";
	}
	
	// URL create is where data is submitted to
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	// show form input data in html - add object parameters
	public String submitForm(User user) {
		// after form is submitted it redirects to dataResult.html in templates
		return "dataResult";
		// URL: http://localhost:8080/create
		// webpage: will display the dataResult.html data
	}
	
	
}
