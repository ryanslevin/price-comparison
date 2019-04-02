package com.rs.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.scraper.ScraperController;
import com.rs.webscraper.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ScraperController scraperController;
	
	@GetMapping("/list")
	public String getProductList(Model theModel) throws InterruptedException {
		
		scraperController.scrapeProducts();
		
		//Create a list object and call getProducts method on service
		List<Product> theProducts = productService.getProducts();
		
		//add list object to model
		theModel.addAttribute("theProducts", theProducts);
		
		//return the thymeleaf page
		return "product-list";
	}
	
	
	@GetMapping("/list/{productId}")
	public String getProduct(@PathVariable int productId, Model theModel) {
		
		//call method to get product from service by id
		Product theProduct = productService.getProduct(productId);
		
		//add product to model
		theModel.addAttribute("theProduct", theProduct);
		
		//call method to get PriceHistory objects for Product
		List<PriceHistory> thePriceHistory = productService.getPriceHistory(productId);
		
		theModel.addAttribute("thePriceHistory", thePriceHistory);
		
		//return the thymeleaf page
		return "product";
	}
	
	@GetMapping("/brand/{brand}")
	public String getBrandProducts(@PathVariable String brand, Model theModel) {
		
		//call method to get the products from service by brand
		List<Product> theProducts = productService.getBrandProducts(brand);
		
		//add products to model
		theModel.addAttribute("theProducts", theProducts);
		
		return "product-list";
	}
	
	
	
	
}
