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
import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.entity.Product;
import com.rs.webscraper.entity.Website;

@Component
public class ChainReactionCyclesScraper {

	public PriceHistory scrape(Product product, Website website) {
		
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		try {
		
		String scrapedUrl = product.getChainReactionCyclesComUrl();
			
		//get doc from link
		Document doc = Jsoup.connect(scrapedUrl).get();
		
		//pull elements with the tag script from doc
		Elements elements = doc.getElementsByTag("script"); 
		
		//create String
		String docData = "";
		
		//iterate through elements and look for element with the window.universal_variable
		for (Element element:elements) {
	
			if (element.data().contains("window.universal_variable")) {
				
				//replace blank space and string from the beginning of json data
				docData = element.data().replace("window.universal_variable = ", "").trim();
				break;
			}
		}
		
		//Create new JsonObject to parse json data
		JsonObject jsonObject = new JsonParser().parse(docData).getAsJsonObject();
		
		//Search through json data and assign product json data to product object
		JsonObject productJson = jsonObject.get("product").getAsJsonObject();
		
		//Parse json data and assign to variables
		String salePriceText = productJson.get("price").getAsString();
		String listPriceText = productJson.get("unit_price").getAsString();

		
		//Remove dash and second price if salePriceText has a price range
		salePriceText = salePriceText.replaceAll("-.*$", "");
		
		//Turn string price data into double
		Double salePrice = Double.parseDouble(salePriceText);
		Double listPrice = Double.parseDouble(listPriceText);
		
		return new PriceHistory(product, website, dateFormat.format(date), salePrice, listPrice, scrapedUrl);
		
		}catch (Exception exc){
			exc.printStackTrace();
			return null;
		}
		
		
		
	}

}
