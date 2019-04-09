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
	
	@Column(name="date_time")
	private String dateTimeScraped;
	
	@Column(name="sale_price")
	private double salePrice;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="scraped_url")
	private String scrapedUrl;
	
	public PriceHistory() {
		
	}

	public PriceHistory(Product productId, Website websiteId, 
			String dateTimeScraped, double salePrice, double unitPrice, String scrapedUrl ) {
		super();
		this.productId = productId;
		this.websiteId = websiteId;
		this.dateTimeScraped = dateTimeScraped;
		this.salePrice = salePrice;
		this.unitPrice = unitPrice;
		this.scrapedUrl = scrapedUrl;
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

	public String getDateTimeScraped() {
		return dateTimeScraped;
	}

	public void setDateTimeScraped(String dateTimeScraped) {
		this.dateTimeScraped = dateTimeScraped;
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
	
	public String getScrapedUrl() {
		return scrapedUrl;
	}

	public void setScrapedUrl(String scrapedUrl) {
		this.scrapedUrl = scrapedUrl;
	}

	@Override
	public String toString() {
		return "PriceHistory [id=" + id + ", productId=" + productId + ", websiteId=" + websiteId + ", dateTimeScraped="
				+ dateTimeScraped + ", salePrice=" + salePrice 
				+ ", unitPrice=" + unitPrice + ", scrapedUrl=" +scrapedUrl+"]";
	}
	
	

	
	
	
	
	
	
	
}
