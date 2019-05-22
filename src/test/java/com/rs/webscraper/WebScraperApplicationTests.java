package com.rs.webscraper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rs.webscraper.util.PriceCleaner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WebScraperApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	
	/*
	 * First unit test! Method doesn't follow SRP, that will need to be updated
	 * and unit test split into multiple parts
	 * 
	 */
	
	@Test
	public void priceCleanerRemovesSecondValue() {
		
		PriceCleaner priceCleaner = new PriceCleaner();
		
		
		Double result = priceCleaner.convert("$1.00-$2.00");
		
		assert result == 1.00;
		
	}
	
	

}
