package com.rs.webscraper.scraper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.webscraper.entity.Currency;
import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.entity.Website;
import com.rs.webscraper.util.CurrencyChecker;

@Component
public class WiggleUKScraper {
	
	@Autowired
	CurrencyChecker currencyChecker;
	
	public PriceHistory scrape(Product product, Website website) {
		
		//create formatters for date and time fields
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		try {
			
		//Get url for page being scraped
		String scrapedUrl = product.getWiggleComUrl();	
		
		Document doc = Jsoup.connect(scrapedUrl).get();
		
		//get elements properties
		String salePriceText = doc.getElementsByClass("js-unit-price").text();
		String unitPriceText = doc.getElementsByClass("js-list-price").text();
		String currencyText = doc.getElementsByClass("bem-header__language-selector").attr("data-current-currency");
		
		//Remove dash and second price if salePriceText has a price range
		salePriceText = salePriceText.replaceAll("-.*$", "");
		unitPriceText = unitPriceText.replaceAll("-.*$", "");
		
		//remove nondigits from string, leaves decimal in place
		salePriceText = salePriceText.replaceAll("[a-z A-Z $ ,]", "");
		unitPriceText = unitPriceText.replaceAll("[a-z A-Z $ ,]", "");  

		Currency currency = currencyChecker.checkCurrency(currencyText);
		
		//turn string into double
		Double salePrice = Double.parseDouble(salePriceText);
		Double unitPrice = Double.parseDouble(unitPriceText);

		//create and return new product object
		return new PriceHistory(product, website, dateFormat.format(date), timeFormat.format(date), salePrice, unitPrice, scrapedUrl, currency);

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
