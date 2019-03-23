package com.rs.webscraper.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class Product {
	
	//Variables with column mapping
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="manufacturer")
	private String manufacturer;
	
	@Column(name="sale_price")
	private double salePrice;
	
	@Column(name="category")
	private String category;
	
	@Column(name="list_price")
	private Double listPrice;
	
	@Column(name="product_url")
	private String productUrl;
	
	@Column(name="image_url")
	private String imageUrl;

	//Constructors for products
	
	public Product() {
		
	}
	


	public Product(String title, String manufacturer, double salePrice, String category, Double listPrice,
			String productUrl, String imageUrl) {
		super();
		this.title = title;
		this.manufacturer = manufacturer;
		this.salePrice = salePrice;
		this.category = category;
		this.listPrice = listPrice;
		this.productUrl = productUrl;
		this.imageUrl = imageUrl;
	}



	//Getters and setters for products
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public Double getListPrice() {
		return listPrice;
	}



	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}



	public String getProductUrl() {
		return productUrl;
	}



	public void setProductUrl(String productUrl) {
		this.productUrl = productUrl;
	}



	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	

}
