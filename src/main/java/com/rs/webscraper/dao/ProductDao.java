package com.rs.webscraper.dao;

import java.util.List;

import com.rs.webscraper.entity.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	
	public void saveProduct(Product newProduct);

	public Product getProduct(int id);
}
