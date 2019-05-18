package com.rs.webscraper.service;

import java.util.List;

import com.rs.webscraper.entity.PriceHistory;

public interface PriceHistoryService {

	public List<PriceHistory> getPriceHistory(int productId, int currencyId);
	
	public List<PriceHistory> getCurrentPrices(int productId, int currencyId);
}
