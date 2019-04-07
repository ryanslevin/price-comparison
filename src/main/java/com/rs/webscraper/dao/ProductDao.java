package com.rs.webscraper.dao;

import java.util.List;

import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;

public interface ProductDao {
	
	public List<Product> getProducts();
	
	public void savePriceHistory(PriceHistory priceHistory);

	public Product getProduct(int id);

	public List<Product> getBrandProducts(String brand);

	public List<PriceHistory> getPriceHistory(int productId);

	public List<Product> getCategoryProducts(String category);

	public List<Product> getSubCategoryProducts(String subCategory);

	public PriceHistory getLatestWigglePrice(int productId);

	public PriceHistory getLatestCrcPrice(int productId);

}
