package com.rs.webscraper.dao;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rs.webscraper.entity.PriceHistory;
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
	public void savePriceHistory(PriceHistory priceHistory) {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);

		//save or update product to the db
		session.saveOrUpdate(priceHistory);
		
	}

	@Override
	public Product getProduct(int id) {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//get product from session and return it
		return session.get(Product.class, id);

	}

	@Override
	public List<Product> getBrandProducts(String brand) {

		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query
		Query getProductsByBrand = session.createQuery("FROM Product WHERE (Brand = '"+brand+"')");
		
		System.out.println(getProductsByBrand);
		
		//get products where brand equals param
		List<Product> theProducts = getProductsByBrand.getResultList();
		
		//return products
		return theProducts;
	}

	@Override
	public List<PriceHistory> getPriceHistory(int productId) {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query
		Query getPriceHistory = session.createQuery(
				"FROM PriceHistory WHERE (productId = "+productId+") ORDER BY date_time DESC").setFirstResult(0).setMaxResults(20);
		
		//get PriceHistory where productId equals param
		List<PriceHistory> thePriceHistory = getPriceHistory.getResultList();

		return thePriceHistory;
	}

	@Override
	public List<Product> getCategoryProducts(String category) {

		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query
		Query getProductsByCategory = session.createQuery("FROM Product WHERE (Category = '"+category+"')");
		
		System.out.println(getProductsByCategory);
		
		//get products where category equals param
		List<Product> theProducts = getProductsByCategory.getResultList();
		
		//return products
		return theProducts;
	}
	
	@Override
	public List<Product> getSubCategoryProducts(String subCategory) {

		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query
		Query getProductsBySubCategory = session.createQuery("FROM Product WHERE (subCategory = '"+subCategory+"')");
		
		System.out.println("FROM Product WHERE (subCategory = '"+subCategory+"')");
		System.out.println(getProductsBySubCategory.toString());
		
		//get products where category equals param
		List<Product> theProducts = getProductsBySubCategory.getResultList();
		System.out.println(theProducts);
		
		//return products
		return theProducts;
	}

	@Override
	public List<PriceHistory> getCurrentPrices(int productId) {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query to get the most recent pricehistory for product from wiggle, max result of 1
		Query getWiggleCurrentPrice = session.createQuery("FROM PriceHistory WHERE "
				+ "(productId = "+productId+" AND websiteId = 1)"
						+ " ORDER BY date_time DESC").setFirstResult(0).setMaxResults(1);
		
		//create query to get the most recent pricehistory for product from crc, max result of 1		
		Query getCrcCurrentPrice = session.createQuery("FROM PriceHistory WHERE "
				+ "(productId = "+productId+" AND websiteId = 2)"
						+ " ORDER BY date_time DESC").setFirstResult(0).setMaxResults(1);		
		
		//Add pricehistories to currentPrices list
		List<PriceHistory> currentPrices = getWiggleCurrentPrice.getResultList();
		currentPrices.addAll(getCrcCurrentPrice.getResultList());

		//Sort list based on the lowest sale price
		currentPrices.sort(Comparator.comparing(PriceHistory::getSalePrice));
		
		//return the current price histories
		return currentPrices;
	}
	
	
}
