package com.rs.webscraper.service;

import java.util.List;

import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.scraper.WiggleUKScraper;

public interface ProductService {

	public List<Product> getProducts();
	
	public Product getProduct(int id);
	
	public List<Product> getBrandProducts(String brand);

	public List<PriceHistory> getPriceHistory(int productId);
	
	
}
