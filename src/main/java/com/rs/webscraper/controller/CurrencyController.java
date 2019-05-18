package com.rs.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.webscraper.entity.Currency;
import com.rs.webscraper.service.CurrencyService;

@RestController
public class CurrencyController {
	
	@Autowired
	CurrencyService currencyService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/currencies")
	public List<Currency> getCurrencies() {
		return currencyService.getCurrencies();
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("currency/{id}")
	public Currency getCurrency(@PathVariable int id) {
		return currencyService.getCurrency(id);
	}

}
