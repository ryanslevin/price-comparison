package com.rs.webscraper.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.webscraper.entity.Currency;
import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.entity.Website;
import com.rs.webscraper.util.CurrentDateTime;
import com.rs.webscraper.util.PriceCleaner;

@Component
public class MerlinCyclesComScraper {
		
	@Autowired
	CurrentDateTime currentDateTime;
	
	@Autowired
	PriceCleaner priceCleaner;
	
	public PriceHistory scrape(Product product, Website website, Currency currency){
		
		try {
			

		//Get url for page being scraped
		String scrapedUrl = product.getMerlinCyclesComUrl();
		
		//use Jsoup to scrape url and return as a doc
		Document doc = Jsoup.connect(scrapedUrl).get();
		
		//Parse the doc and look for the productContainer class with the data-baseprice and data-baserrp attributes.
		String salePriceText = doc.getElementsByClass("productContainer").attr("data-baseprice");
		String unitPriceText = doc.getElementsByClass("productContainer").attr("data-baserrp");
		
		//Clean string and convert to doubles with PriceCleaner
		Double salePrice = priceCleaner.convert(salePriceText);
		Double unitPrice = priceCleaner.convert(unitPriceText);
		
		//Assign 0.00 to usedPrice, not valid for MerlinCycles
		Double usedPrice = 0.00;
		
		return new PriceHistory(product, website, currentDateTime.getDate(), 
				currentDateTime.getTime(), salePrice, unitPrice, usedPrice, scrapedUrl, currency);
		
		} catch (Exception e){
			e.printStackTrace();
			return null;
		}
	
		

		
	}

}
