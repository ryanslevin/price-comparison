package com.rs.webscraper.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.webscraper.entity.Currency;
import com.rs.webscraper.service.CurrencyService;

@Component
public class CurrencyChecker {
	
	@Autowired
	CurrencyService currencyService;
	
	public Currency checkCurrency(String currencyCode) {
		
		//Get list of currencies from db
		List<Currency> currencies = currencyService.getCurrencies();
		
		//iterate through currencies and compare codes, if match found return that currency
		for (Currency currency:currencies) {
			if (currency.checkCode(currencyCode)) {
				return currency;
			}
		}
		
		//If no matching code found return null and print to console
		System.out.println("No currency code matches: "+currencyCode);
		return null;
	}
	

}
