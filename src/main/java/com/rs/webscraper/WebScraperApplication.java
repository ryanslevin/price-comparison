package com.rs.webscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class WebScraperApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebScraperApplication.class, args);
	}

}
