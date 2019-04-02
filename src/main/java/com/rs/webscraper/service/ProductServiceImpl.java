package com.rs.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.webscraper.dao.ProductDao;
import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.scraper.WiggleUKScraper;

@Service
public class ProductServiceImpl implements ProductService {

	
	//Autowire product database access object
	@Autowired
	ProductDao productDao;
	
	//Autowire wiggle.co.uk scraper
	@Autowired
	WiggleUKScraper wiggleUKScraper;
	
	@Override
	public List<Product> getProducts() {
		
		return productDao.getProducts();
	}

	@Override
	public Product getProduct(int id) {
		
		return productDao.getProduct(id);
	}

	@Override
	public List<Product> getBrandProducts(String brand) {

		return productDao.getBrandProducts(brand);
	}

	@Override
	public List<PriceHistory> getPriceHistory(int productId) {
		
		return productDao.getPriceHistory(productId);
	}
}
