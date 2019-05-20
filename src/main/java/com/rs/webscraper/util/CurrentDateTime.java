package com.rs.webscraper.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateTime {
	
	private DateFormat dateFormat;
	private DateFormat timeFormat;
	private Date date;

	public CurrentDateTime() {
		
		//create formatters for date and time fields
		this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		this.timeFormat = new SimpleDateFormat("HH:mm:ss");
		this.date = new Date();
		
	}
	
	public String getDate() {
		return dateFormat.format(date);
	}
	
	public String getTime() {
		return timeFormat.format(date);
	}

}
