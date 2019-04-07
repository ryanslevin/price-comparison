package com.rs.webscraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.rs.webscraper.scraper.ScraperScheduler;

@Component
public class WebScraperApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	/*
	@Autowired
	ScraperScheduler scraperScheduler;
	*/
	
	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		
		/*
		try {
			scraperScheduler.startScraper();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
	
	}
	
}
