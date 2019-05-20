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
import com.rs.webscraper.util.CurrentDateTime;
import com.rs.webscraper.util.PriceCleaner;

@Component
public class ChainReactionCyclesScraper {

	@Autowired
	CurrencyChecker currencyChecker;

	@Autowired
	PriceCleaner priceCleaner;

	@Autowired
	CurrentDateTime currentDateTime;

	public PriceHistory scrape(Product product, Website website, Currency currency) {

		try {

			// get url from product
			String scrapedUrl = product.getChainReactionCyclesComUrl();

			// get doc from link
			Document doc = Jsoup.connect(scrapedUrl).cookie("currencyCode", currency.getCode())
					.cookie("countryCode", currency.getCountryCode()).get();

			// pull elements with the tag script from doc
			Elements elements = doc.getElementsByTag("script");

			// create String
			String docData = "";

			// iterate through elements and look for element with the
			// window.universal_variable
			for (Element element : elements) {

				if (element.data().contains("window.universal_variable")) {

					// replace blank space and string from the beginning of json data
					docData = element.data().replace("window.universal_variable = ", "").trim();
					break;
				}
			}

			// Create new JsonObject to parse json data
			JsonObject jsonObject = new JsonParser().parse(docData).getAsJsonObject();

			// Search through json data and assign product json data to product object
			JsonObject productJson = jsonObject.get("product").getAsJsonObject();
			JsonObject userJson = jsonObject.get("user").getAsJsonObject();

			// Parse json data and assign to variables
			String salePriceText = productJson.get("price").getAsString();
			String unitPriceText = productJson.get("unit_price").getAsString();

			// Pass scraped price text into helper method, returns a cleaned double
			Double salePrice = priceCleaner.convert(salePriceText);
			Double unitPrice = priceCleaner.convert(unitPriceText);

			// Assigning null value to usedPrice as invalid for CRC.
			Double usedPrice = 0.00;

			return new PriceHistory(product, website, currentDateTime.getDate(), currentDateTime.getTime(), salePrice,
					unitPrice, usedPrice, scrapedUrl, currency);

		} catch (Exception exc) {
			exc.printStackTrace();
			return null;
		}

	}

}
