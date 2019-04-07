package com.rs.webscraper.scraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScraperScheduler {
	
	@Autowired
	ScraperController scraperController;
	
	@Scheduled(fixedRate = 10000000)
	public void startScraper() throws InterruptedException {
		
		scraperController.scrapeProducts();
		
	}

}
