package com.rs.webscraper.scraper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.entity.Website;

@Component
public class WiggleUKScraper {
	
	public static PriceHistory scrape(Product product, Website website) {
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		
		try {
			
		//Get url for page being scraped
		String scrapedUrl = product.getWiggleComUrl();	
		
		Document doc = Jsoup.connect(scrapedUrl).get();
		
		//get elements properties
		String salePriceText = doc.getElementsByClass("js-unit-price").text();
		String unitPriceText = doc.getElementsByClass("js-list-price").text();
		
		//Remove dash and second price if salePriceText has a price range
		salePriceText = salePriceText.replaceAll("-.*$", "");
		unitPriceText = salePriceText.replaceAll("-.*$", "");
		
		//remove nondigits from string, leaves decimal in place
		salePriceText = salePriceText.replaceAll("[a-z A-Z $ ,]", "");
		unitPriceText = unitPriceText.replaceAll("[a-z A-Z $ ,]", "");  

		//turn string into double
		Double salePrice = Double.parseDouble(salePriceText);
		Double unitPrice = Double.parseDouble(unitPriceText);

		//create and return new product object
		return new PriceHistory(product, website, dateFormat.format(date), salePrice, unitPrice, scrapedUrl);

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
