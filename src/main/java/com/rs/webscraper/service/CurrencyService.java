package com.rs.webscraper.service;

import java.util.List;

import com.rs.webscraper.entity.Currency;

public interface CurrencyService {

	public List<Currency> getCurrencies();
	
	public Currency getCurrency(int currencyId);
	
}
