package com.rs.webscraper.dao;

import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rs.webscraper.entity.PriceHistory;

@Repository
public class PriceHistoryDaoImpl implements PriceHistoryDao {

	@Autowired
	EntityManager entityManager;
	
	@Override
	public void savePriceHistory(PriceHistory priceHistory) {
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);

		//save or update product to the db
		session.saveOrUpdate(priceHistory);
		
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
