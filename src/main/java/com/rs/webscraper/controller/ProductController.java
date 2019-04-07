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
		
		//Commenting out to test @Scheduled scraping
		/*
		scraperController.scrapeProducts();
		*/
		
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
		
		//call method to get full PriceHistory objects for Product
		List<PriceHistory> thePriceHistory = productService.getPriceHistory(productId);

		//add PriceHistory to the model
		theModel.addAttribute("thePriceHistory", thePriceHistory);
		
		//call method to get latest wiggle price
		PriceHistory latestWigglePrice = productService.getLatestWigglePrice(productId);
		PriceHistory latestCrcPrice = productService.getLatestCrcPrice(productId);
		
		theModel.addAttribute("latestWigglePrice", latestWigglePrice);
		theModel.addAttribute("latestCrcPrice", latestCrcPrice);
		
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
	
	
	@GetMapping("/category/{category}")
	public String getCategoryProducts(@PathVariable String category, Model theModel) {
		
		//call method to get the products from service by category
		List<Product> theProducts = productService.getCategoryProducts(category);
		
		//add products to model
		theModel.addAttribute("theProducts", theProducts);
		
		return "product-list";
	}
	
	@GetMapping("/subcategory/{subCategory}")
	public String getSubCategoryProducts(@PathVariable String subCategory, Model theModel) {
		
		//call method to get the products from service by category
		List<Product> theProducts = productService.getSubCategoryProducts(subCategory);
		
		//add products to model
		theModel.addAttribute("theProducts", theProducts);
		
		return "product-list";
	}
	
	
	
	
	
}
