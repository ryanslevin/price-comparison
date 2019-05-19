package com.rs.webscraper.scraper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.entity.Website;

@Component
public class ScraperController {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	WiggleUKScraper wiggleUkScraper;
	
	@Autowired
	ChainReactionCyclesScraper chainReactionCyclesScraper;
	
	@Transactional
	public void scrapeProducts() throws InterruptedException{
		
		//get current hibernate session
		Session session = entityManager.unwrap(Session.class);
		
		//create query to 
		Query getProducts = session.createQuery("from Product", Product.class);
		Query getWebsites = session.createQuery("from Website", Website.class);
		
		//execute query and add results to list
		List<Product> theProducts = getProducts.getResultList();
		System.out.println("PRODUCTS RETRIEVED FROM DB");
		List<Website> theWebsites = getWebsites.getResultList();
		System.out.println("WEBSITES RETRIEVED FROM DB");
		
		for (Product product : theProducts) {
			
			//Create PriceHistory objects for each site and call appropriate scraping method to populate
			System.out.println("Scraping wiggle");
			PriceHistory wigglePriceHistory = wiggleUkScraper.scrape(product, theWebsites.get(0));
			System.out.println("Scraping crc");			
			PriceHistory chainReactionPriceHistory = chainReactionCyclesScraper.scrape(product, theWebsites.get(1));

			//save PriceHistory products to DB
			System.out.println("Saving wiggle to DB");
			session.saveOrUpdate(wigglePriceHistory);
			System.out.println("Saving crc to DB");
			session.saveOrUpdate(chainReactionPriceHistory);

			
		}
		
		
		
		
	}

}
