package com.rs.webscraper.util;

import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;

public class Tester {

	public static void main(String[] args) throws IOException {
		
		HashMap<String,String> cookieMap = new HashMap<String,String>();
		cookieMap.put("__cfduid", "");
		cookieMap.put("JSESSIONID", "");
		cookieMap.put("languageCode", "en");	
		cookieMap.put("currencyCode", "USD");
		cookieMap.put("countryCode", "US");
		cookieMap.put("CRCRecentlyViewProductsCookie", "");			

		// get url from product
		String scrapedUrl = "https://www.chainreactioncycles.com/continental-grand-prix-4000s-ii-road-tyre/rp-prod120460";

		// get doc from link
		System.out.println(Jsoup.connect(scrapedUrl).method(Method.GET).cookies(cookieMap).get());
		

	}

}