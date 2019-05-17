package com.rs.webscraper.dao;

import java.util.List;

import com.rs.webscraper.entity.PriceHistory;

public interface PriceHistoryDao {
	
	public void savePriceHistory(PriceHistory priceHistory);
	
	public List<PriceHistory> getPriceHistory(int productId);
	
	public List<PriceHistory> getCurrentPrices(int productId);

}
