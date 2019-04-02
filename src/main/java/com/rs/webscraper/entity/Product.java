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
	private Integer id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="brand")
	private String brand;

	@Column(name="category")
	private String category;
	
	@Column(name="sub_category")
	private String subCategory;
	
	@Column(name="wiggle_com_url")
	private String wiggleComUrl;

	@Column(name="chain_reaction_cycles_com_url")
	private String chainReactionCyclesComUrl;
	
	@Column(name="amazon_com_url")
	private String amazonComUrl;
	
	@Column(name="image_url")
	private String imageUrl;

	//Constructors for products
	
	public Product() {
		
	}

	public Product(String name, String brand, String category, String subCategory, String wiggleComUrl,
			String chainReactionCyclesComUrl, String amazonComUrl, String imageUrl) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.subCategory = subCategory;
		this.wiggleComUrl = wiggleComUrl;
		this.chainReactionCyclesComUrl = chainReactionCyclesComUrl;
		this.amazonComUrl = amazonComUrl;
		this.imageUrl = imageUrl;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	public String getWiggleComUrl() {
		return wiggleComUrl;
	}

	public void setWiggleComUrl(String wiggleComUrl) {
		this.wiggleComUrl = wiggleComUrl;
	}

	public String getChainReactionCyclesComUrl() {
		return chainReactionCyclesComUrl;
	}

	public void setChainReactionCyclesComUrl(String chainReactionCyclesComUrl) {
		this.chainReactionCyclesComUrl = chainReactionCyclesComUrl;
	}

	public String getAmazonComUrl() {
		return amazonComUrl;
	}

	public void setAmazonComUrl(String amazonComUrl) {
		this.amazonComUrl = amazonComUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", subCategory="
				+ subCategory + ", wiggleComUrl=" + wiggleComUrl + ", chainReactionCyclesComUrl="
				+ chainReactionCyclesComUrl + ", amazonComUrl=" + amazonComUrl + ", imageUrl=" + imageUrl + "]";
	}
	

	
	
}
