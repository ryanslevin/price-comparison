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

	@Override
	public void saveProduct(Product newProduct) {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		System.out.println("ProductDao------------Saving product to DB");
		//save or update product to the db
		session.saveOrUpdate(newProduct);
		
	}

	@Override
	public Product getProduct(int id) {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//get product from session and return it
		return session.get(Product.class, id);

	}

	
	
}
