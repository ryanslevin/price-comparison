package com.rs.webscraper.scraper;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class PageScraper {
	
	
	public static void main(String[] args) {
		
		
		
		scrape("https://www.wiggle.co.uk/fast-forward-carbon-f6d-fcc-dt240-sp-wheelset/");
	}
	
	
	
	public static void scrape(String url) {
		
		try {
		Document doc = Jsoup.connect(url).get();
		
		//get elements 
		String title = doc.getElementById("productTitle").text();
		String salePriceText = doc.getElementsByClass("js-unit-price").text();
		String listPriceText = doc.getElementsByClass("js-list-price").text();
		List<Element> listOfSKUSelectors = doc.getElementsByClass("bem-sku-selector__internal");
		String manufacturer = doc.getElementsByAttributeValue("data-ga-brand", "Brand").text();
		
		//remove nondigits from string, leaves decimal in place
		salePriceText = salePriceText.replaceAll("[a-z A-Z $ ,]", "");
		listPriceText = listPriceText.replaceAll("[a-z A-Z $ ,]", "");  

		//turn string into double
		Double salePrice = Double.parseDouble(salePriceText);
		Double listPrice = Double.parseDouble(listPriceText);

		
		
		System.out.println("title: "+title);
		System.out.println("salePrice: "+salePrice);
		System.out.println("listPrice: "+listPrice);
		System.out.println("manufacturer: "+manufacturer);
		
		for (Element element : listOfSKUSelectors) {
			System.out.println(element.elementSiblingIndex());
		}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
