package com.rs.webscraper.service;

import java.util.List;

import com.rs.webscraper.entity.Product;
import com.rs.webscraper.scraper.PageScraper;

public interface ProductService {

	public List<Product> getProducts();
	
	public Product getProduct(int id);
	
	public void saveProduct(String url);
	
	
}
