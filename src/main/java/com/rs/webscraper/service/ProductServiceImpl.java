package com.rs.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.webscraper.dao.ProductDao;
import com.rs.webscraper.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	
	//Autowire product database access object
	@Autowired
	ProductDao productDao;
	
	@Override
	public List<Product> getProducts() {
		
		return productDao.getProducts();
	}

}
