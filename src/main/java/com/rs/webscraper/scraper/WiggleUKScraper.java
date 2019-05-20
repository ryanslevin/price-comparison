package com.rs.webscraper.scraper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.rs.webscraper.entity.Currency;
import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.entity.Website;
import com.rs.webscraper.util.CurrencyChecker;

@Component
public class WiggleUKScraper {
	
	@Autowired
	CurrencyChecker currencyChecker;
	
	public PriceHistory scrape(Product product, Website website, Currency currency) {
		
		//create formatters for date and time fields
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		Date date = new Date();
		
		try {
			
		//Get url for page being scraped
		String scrapedUrl = product.getWiggleComUrl()+"?curr="+currency.getCode();
		
		Document doc = Jsoup.connect(scrapedUrl).get();
		
		//Pull elements with the tag script from the doc
		Elements elements = doc.getElementsByTag("script");
		
		String docData = "";

		//iterate through elements and look for element with the window.universal_variable
		for (Element element:elements) {
	
			if (element.data().contains("window.universal_variable.product")) {
				
				//replace blank space and string from the beginning of json data
				docData = element.data().replace("window.universal_variable = window.universal_variable || { \"version\": \"1.2.1\" };", "").trim();
				docData = docData.replace("window.universal_variable.product = ","").trim();
				break;
			}
		}
		
		//Create new JsonObject to parse json data
		JsonObject jsonObject = new JsonParser().parse(docData).getAsJsonObject();

		//Parse json data and assign to variables
		String salePriceText = jsonObject.get("unit_sale_price").getAsString();
		String unitPriceText = jsonObject.get("unit_price").getAsString();
		
		//Get currency code from the doc. Can this be changed to use JSON data? Which is faster JSON or Jsoup?
		String currencyText = doc.getElementsByClass("bem-header__language-selector").attr("data-current-currency");

		//Remove dash and second price if salePriceText has a price range
		salePriceText = salePriceText.replaceAll("-.*$", "");
		unitPriceText = unitPriceText.replaceAll("-.*$", "");
		
		//remove nondigits from string, leaves decimal in place
		salePriceText = salePriceText.replaceAll("[a-z A-Z $ ,]", "");
		unitPriceText = unitPriceText.replaceAll("[a-z A-Z $ ,]", ""); 
		
		//turn string into double
		
		Double salePrice;
		Double unitPrice;
		
		if (salePriceText.equals("")) {
			salePrice = Double.parseDouble(unitPriceText);
		}else {
			salePrice = Double.parseDouble(salePriceText);
		}
		
			unitPrice = Double.parseDouble(unitPriceText);

		//create and return new product object
		return new PriceHistory(product, website, dateFormat.format(date), timeFormat.format(date), salePrice, unitPrice, scrapedUrl, currency);

		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
