package com.rs.webscraper.scraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import com.rs.webscraper.entity.Product;

@Component
public class PageScraper {
	
	
	public static void main(String[] args) {
		
		
		
		scrape("https://www.wiggle.co.uk/fast-forward-carbon-f6d-fcc-dt240-sp-wheelset/");
	}
	
	
	
	public static Product scrape(String url) {
				
		try {
		Document doc = Jsoup.connect(url).get();
		
		//get elements properties
		String title = doc.getElementById("productTitle").text();
		String salePriceText = doc.getElementsByClass("js-unit-price").text();
		String listPriceText = doc.getElementsByClass("js-list-price").text();
		String manufacturer = doc.getElementsByAttributeValue("data-ga-action", "Brand").attr("data-ga-label");
		String category = doc.getElementsByAttributeValue("data-ga-action", "Category").attr("data-ga-label");
		String productUrl = doc.location();
		String imageUrl = "http:"+doc.getElementById("pdpGalleryImage").attr("src");
		
		
		//remove nondigits from string, leaves decimal in place
		salePriceText = salePriceText.replaceAll("[a-z A-Z $ ,]", "");
		listPriceText = listPriceText.replaceAll("[a-z A-Z $ ,]", "");  

		//turn string into double
		Double salePrice = Double.parseDouble(salePriceText);
		Double listPrice = Double.parseDouble(listPriceText);

		
		//create and return new product object
		
		return new Product(title, manufacturer, salePrice, category, listPrice, productUrl, imageUrl);
		
		/*
		
		System.out.println("title: "+title);
		System.out.println("salePrice: "+salePrice);
		System.out.println("listPrice: "+listPrice);
		System.out.println("manufacturer: "+manufacturer);
		System.out.println("category: "+category);
		System.out.println("productUrl: "+productUrl);
		System.out.println("imgUrl: "+imageUrl);
		
		*/
		
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

}
