package com.rs.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.webscraper.dao.CurrencyDao;
import com.rs.webscraper.entity.Currency;

@Service
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	CurrencyDao currencyDao;
	
	@Override
	public List<Currency> getCurrencies() {
		return currencyDao.getCurrencies();
	}
	
	@Override
	public Currency getCurrency(int id) {
		return currencyDao.getCurrency(id);
	}
	
}
