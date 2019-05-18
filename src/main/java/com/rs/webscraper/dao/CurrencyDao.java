package com.rs.webscraper.dao;

import java.util.List;

import com.rs.webscraper.entity.Currency;

public interface CurrencyDao {

	public List<Currency> getCurrencies();
	
	public Currency getCurrency(int currencyId);
	
}
