package com.amie.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // controller routes request
@RequestMapping("/greeting") // root url is "greeting"

 class HelloController {
	
	//  Controller methods
	//	method = RequestMethod.GET - this is the GET request
	//	method = RequestMethod.POST - this is the POST request
	//	method = RequestMethod.DELETE - this is the DELETE request
	
	@RequestMapping("/basic")
	public String sayHello() {
		return "<h1>hello there</h1>";
	}
	
	@RequestMapping("/proper")
	public String sayProperHello() {
		return "<h1>hello there, how are you?</h1>";
	}
	
	@RequestMapping("/user_entry")
	public String userForm() {
		return "<form action=\"/greeting/user_greeting\", method=\"POST\">\n" + 
		"  First name:<br>\n" + 
		"  <input type=\"text\" name=\"firstname\">\n" + 
		"  <br>\n" + 
		"  Last name:<br>\n" + 
		"  <input type=\"text\" name=\"lastname\">\n" + 
		"  <br><br>\n" + 
		"  <input type=\"submit\" value=\"Submit\">\n" + 
		"</form> ";
	}
	
	@RequestMapping(value = "/user_greeting", method = RequestMethod.GET)
	public String printUserGreeting(@RequestParam String firstname, @RequestParam String lastname) {
		return "Name: " + firstname + " " + lastname ;
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
	public String getOrder(@PathVariable String id) {
		return "Order ID: " + id;
	}
}


// url: localhost: greeting/basic