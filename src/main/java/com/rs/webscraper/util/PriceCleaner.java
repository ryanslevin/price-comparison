package com.rs.webscraper.util;

public class PriceCleaner {

	
	//Take a string input, clean the data and then return a double
	public Double convert(String price) {
		
		//Remove dash and second price if price has a price range
		price = price.replaceAll("-.*$", "");
		
		//remove nondigits from string, leaves decimal in place
		price = price.replaceAll("[a-z A-Z $ £ € ,]", "");
		
		return Double.parseDouble(price);
		
	}
	
}
