package com.rs.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.scraper.ScraperController;
import com.rs.webscraper.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ScraperController scraperController;
	
	@RequestMapping("/products")
	public List<Product> getProductList(Model theModel) {
		
		//Create a list object and call getProducts method on service
		List<Product> theProducts = productService.getProducts();
		
		//return the products
		return theProducts;
	}
	
	
	@RequestMapping("/product/{productId}")
	public Product getProduct(@PathVariable int productId, Model theModel) {
		
		//call method to get product from service by id
		Product theProduct = productService.getProduct(productId);
		
		//return the thymeleaf page
		return theProduct;
	}
	
	@RequestMapping("/pricehistory/{productId}")
	public List<PriceHistory> getPriceHistory(@PathVariable int productId, Model theModel) {
		
		//call method to get full PriceHistory objects for Product
		List<PriceHistory> thePriceHistory = productService.getPriceHistory(productId);

		//call method to get current pricing info
		List<PriceHistory> currentPrices = productService.getCurrentPrices(productId);

		//return the thymeleaf page
		return thePriceHistory;
	}	
	
	@RequestMapping("/currentprices/{productId}")
	public List<PriceHistory> getCurrentPrices(@PathVariable int productId, Model theModel) {
		
		//call method to get current pricing info
		List<PriceHistory> currentPrices = productService.getCurrentPrices(productId);

		//return the thymeleaf page
		return currentPrices;
	}		
	
	
	@RequestMapping("/brand/{brand}")
	public List<Product> getBrandProducts(@PathVariable String brand, Model theModel) {
		
		//call method to get the products from service by brand
		List<Product> theProducts = productService.getBrandProducts(brand);
		
		return theProducts;
	}
	
	
	@GetMapping("/category/{category}")
	public List<Product> getCategoryProducts(@PathVariable String category, Model theModel) {
		
		//call method to get the products from service by category
		List<Product> theProducts = productService.getCategoryProducts(category);
		
		return theProducts;
	}
	
	@GetMapping("/subcategory/{subCategory}")
	public List<Product> getSubCategoryProducts(@PathVariable String subCategory, Model theModel) {
		
		//call method to get the products from service by category
		List<Product> theProducts = productService.getSubCategoryProducts(subCategory);

		return theProducts;
	}
	
	
	
	
	
}
