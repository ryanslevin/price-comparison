package com.rs.webscraper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rs.webscraper.entity.PriceHistory;
import com.rs.webscraper.service.PriceHistoryService;

@RestController
public class PriceHistoryController {

	@Autowired
	PriceHistoryService priceHistoryService;
	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/pricehistory/{productId}")
	public List<PriceHistory> getPriceHistory(@PathVariable int productId, Model theModel) {
		
		//call method to get full PriceHistory objects for Product
		List<PriceHistory> thePriceHistory = priceHistoryService.getPriceHistory(productId);

		//call method to get current pricing info
		List<PriceHistory> currentPrices = priceHistoryService.getCurrentPrices(productId);

		//return the thymeleaf page
		return thePriceHistory;
	}	

	@CrossOrigin(origins = "http://localhost:3000")
	@RequestMapping("/currentprices/{productId}")
	public List<PriceHistory> getCurrentPrices(@PathVariable int productId, Model theModel) {
		
		//call method to get current pricing info
		List<PriceHistory> currentPrices = priceHistoryService.getCurrentPrices(productId);

		//return the thymeleaf page
		return currentPrices;
	}
}
