package com.rs.webscraper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.rs.webscraper.scraper.ScraperController;

@SpringBootApplication
@EnableAutoConfiguration
public class WebScraperApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(WebScraperApplication.class, args);
	}

}
