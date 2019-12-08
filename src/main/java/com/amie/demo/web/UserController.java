package com.amie.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amie.demo.domain.Product;

@RestController
@RequestMapping("/user") // root URL

public class UserController {
	@RequestMapping("/{userId}")
	public String displayUser(@PathVariable int userId) {
		return "User Found: " + userId;
		// localhost:8080/user/23
		// webpage displays: User Found 23
	}
	
	@RequestMapping("/{userId}/invoices")
	// userId is the path variable and date is the query parameter
	// can make @RequestParam optional  -> @RequestParam(value = "date", required = false) Date dateOrNull
	public String displayUserInvoices(@PathVariable int userId, @RequestParam Date date) {
		return "Invoice found for user: " + userId + "on date: " + date;
		// URL: http://localhost:8080/user/23/invoices?date=1/23/2019
		// webpage displays: Invoice found for user: 23on date: Wed Jan 23 00:00:00 CST 2019
	}
	
	// displays item that user owns
	@RequestMapping("/{userId}/items")
	public List<String> displayStringJson() {
		return Arrays.asList("shoes", "laptop", "button");
		// URL: http://localhost:8080/user/23/items
		// webpage displays a json list: [ "shoes", "laptop", "button"]
	}
	
	// Getting array of products from DB
	@RequestMapping("/{userId}/products_as_json")
	public List<Product> displayProductsJson() {
		return Arrays.asList(new Product(1, "laptop", 1000.99),
				new Product(2, "books", 20.99),
				new Product(3, "bag", 35.99));
		
		// URL: http://localhost:8080/user/4/products_as_json
		// webpage: displays array product in json
		// [{"id": 1, "name": "laptop", "price": 1000.99 }, {"id": 2,"name": "books","price": 20.99},{"id": 3,"name": "bag","price": 35.99}]
	}
	
	// Getting one product from DB
	@RequestMapping("/{userId}/one_product_as_json")
	public Product displayOneProductJson() {
		return new Product(1, "laptop", 1000.99);
		// URL: http://localhost:8080/user/6/one_product_as_json
		// webpage: display one product in the array in json format
		// {"id": 1, "name": "laptop", "price": 1000.99 }
	}

}
