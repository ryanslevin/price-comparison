package com.rs.webscraper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="price_history")
public class PriceHistory {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@ManyToOne(targetEntity=Product.class)
	@JoinColumn(name = "product_id", referencedColumnName="id")
	private Product productId;
	
	@ManyToOne(targetEntity=Website.class)
	@JoinColumn(name = "website_id", referencedColumnName= "id")
	private Website websiteId;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="sale_price")
	private double salePrice;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="used_price")
	private double usedPrice;
	
	@Column(name="scraped_url")
	private String scrapedUrl;
	
	@ManyToOne(targetEntity=Currency.class)
	@JoinColumn(name="currency_id", referencedColumnName="id")
	private Currency currency;
	
	public PriceHistory() {
		
	}

	public PriceHistory(Product productId, Website websiteId, 
			String date, String time, double salePrice, double unitPrice, 
			double usedPrice, String scrapedUrl, Currency currency ) {
		super();
		this.productId = productId;
		this.websiteId = websiteId;
		this.date = date;
		this.time = time;
		this.salePrice = salePrice;
		this.unitPrice = unitPrice;
		this.usedPrice = usedPrice;
		this.scrapedUrl = scrapedUrl;
		this.currency = currency;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product product) {
		this.productId = productId;
	}

	public Website getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(Website websiteId) {
		this.websiteId = websiteId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}	
	

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getUsedPrice() {
		return usedPrice;
	}

	public void setUsedPrice(double usedPrice) {
		this.usedPrice = usedPrice;
	}	
	
	public String getScrapedUrl() {
		return scrapedUrl;
	}

	public void setScrapedUrl(String scrapedUrl) {
		this.scrapedUrl = scrapedUrl;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		return "PriceHistory [id=" + id + ", productId=" + productId + ", websiteId=" + websiteId + ", date=" + date
				+ ", time=" + time + ", salePrice=" + salePrice + ", unitPrice=" + unitPrice + ", usedPrice="
				+ usedPrice + ", scrapedUrl=" + scrapedUrl + ", currency=" + currency + "]";
	}




	

	
	
	
	
	
	
	
}
