package com.rs.webscraper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.webscraper.dao.PriceHistoryDao;
import com.rs.webscraper.entity.PriceHistory;

@Service
public class PriceHistoryServiceImpl implements PriceHistoryService {

	//Autowire product database access object
	@Autowired
	PriceHistoryDao priceHistoryDao;
	
	@Override
	public List<PriceHistory> getPriceHistory(int productId, int currencyId) {
		
		return priceHistoryDao.getPriceHistory(productId, currencyId);
	}
	
	@Override
	public List<PriceHistory> getCurrentPrices(int productId, int currencyId) {

		return priceHistoryDao.getCurrentPrices(productId, currencyId);
	}
}
