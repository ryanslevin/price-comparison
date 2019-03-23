package com.rs.webscraper.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rs.webscraper.entity.Product;

@Repository
public class ProductDaoImpl implements ProductDao{

	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Product> getProducts() {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query
		Query getProducts = session.createQuery("from Product", Product.class);
		
		//execute query and add results to list
		List<Product> theProducts = getProducts.getResultList();
		
		//return theProducts list
		return theProducts;
	}

	
	
}
