package com.rs.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rs.webscraper.entity.Product;
import com.rs.webscraper.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/list")
	public String getProductList(Model theModel) {
		
		//Create a list object and call getProducts method on service
		System.out.println("\nGetting products from Servoce");
		List<Product> theProducts = productService.getProducts();
		
		//add list object to model
		System.out.println("\nAdding products to model");
		theModel.addAttribute("theProducts", theProducts);
		
		//return the thymeleaf page
		System.out.println("\nReturning product-list");
		return "product-list";
	}
	
	
}
