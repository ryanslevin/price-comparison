package com.rs.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.webscraper.dao.ProductDao;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.scraper.PageScraper;

@Service
public class ProductServiceImpl implements ProductService {

	
	//Autowire product database access object
	@Autowired
	ProductDao productDao;
	
	//Autowire wiggle.co.uk scraper
	@Autowired
	PageScraper pageScraper;
	
	@Override
	public List<Product> getProducts() {
		
		return productDao.getProducts();
	}

	@Override
	public void saveProduct(String url) {
		
		System.out.println("ProductService ---- Calling productDao.saveProduct()");
		productDao.saveProduct(pageScraper.scrape(url));
		
	}

	@Override
	public Product getProduct(int id) {
		
		return productDao.getProduct(id);

	}

}
