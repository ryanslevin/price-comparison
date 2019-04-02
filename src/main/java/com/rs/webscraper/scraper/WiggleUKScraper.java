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
		Document doc = Jsoup.connect(product.getWiggleComUrl()).get();
		
		//get elements properties
		String salePriceText = doc.getElementsByClass("js-unit-price").text();
		String unitPriceText = doc.getElementsByClass("js-list-price").text();

		//remove nondigits from string, leaves decimal in place
		salePriceText = salePriceText.replaceAll("[a-z A-Z $ ,]", "");
		unitPriceText = unitPriceText.replaceAll("[a-z A-Z $ ,]", "");  

		//turn string into double
		Double salePrice = Double.parseDouble(salePriceText);
		Double unitPrice = Double.parseDouble(unitPriceText);

		
		//create and return new product object
		return new PriceHistory(product, website, dateFormat.format(date), salePrice, unitPrice);

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
