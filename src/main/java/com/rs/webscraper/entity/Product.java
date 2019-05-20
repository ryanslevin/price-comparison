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
	
	@Column(name="wiggle_co_uk_url")
	private String wiggleCoUkUrl;

	@Column(name="competitive_cyclist_com_url")
	private String competitiveCyclistComUrl;
	
	@Column(name="merlin_cycles_com_url")
	private String merlinCyclesComUrl;
	
	@Column(name="tredz_co_uk_url")
	private String tredzCoUkUrl;
	
	@Column(name="jenson_usa_com_url")
	private String jensonUsaComUrl;
	//Constructors for products
	
	public Product() {
		
	}

	public Product(String name, String brand, String category, String subCategory, String wiggleComUrl,
			String chainReactionCyclesComUrl, String amazonComUrl, String imageUrl, String wiggleCoUkUrl,
			String competitiveCyclistComUrl, String merlinCyclesComUrl, String tredzCoUkUrl, String jensonUsaComUrl) {
		super();
		this.name = name;
		this.brand = brand;
		this.category = category;
		this.subCategory = subCategory;
		this.wiggleComUrl = wiggleComUrl;
		this.chainReactionCyclesComUrl = chainReactionCyclesComUrl;
		this.amazonComUrl = amazonComUrl;
		this.imageUrl = imageUrl;
		this.wiggleCoUkUrl = wiggleCoUkUrl;
		this.competitiveCyclistComUrl = competitiveCyclistComUrl;
		this.merlinCyclesComUrl = merlinCyclesComUrl;
		this.tredzCoUkUrl = tredzCoUkUrl;
		this.jensonUsaComUrl = jensonUsaComUrl;
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

	public String getWiggleCoUkUrl() {
		return wiggleCoUkUrl;
	}

	public void setWiggleCoUkUrl(String wiggleCoUkUrl) {
		this.wiggleCoUkUrl = wiggleCoUkUrl;
	}

	public String getCompetitiveCyclistComUrl() {
		return competitiveCyclistComUrl;
	}

	public void setCompetitiveCyclistComUrl(String competitiveCyclistComUrl) {
		this.competitiveCyclistComUrl = competitiveCyclistComUrl;
	}

	public String getMerlinCyclesComUrl() {
		return merlinCyclesComUrl;
	}

	public void setMerlinCyclesComUrl(String merlinCyclesComUrl) {
		this.merlinCyclesComUrl = merlinCyclesComUrl;
	}

	public String getTredzCoUkUrl() {
		return tredzCoUkUrl;
	}

	public void setTredzCoUkUrl(String tredzCoUkUrl) {
		this.tredzCoUkUrl = tredzCoUkUrl;
	}

	public String getJensonUsaComUrl() {
		return jensonUsaComUrl;
	}

	public void setJensonUsaComUrl(String jensonUsaComUrl) {
		this.jensonUsaComUrl = jensonUsaComUrl;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", category=" + category + ", subCategory="
				+ subCategory + ", wiggleComUrl=" + wiggleComUrl + ", chainReactionCyclesComUrl="
				+ chainReactionCyclesComUrl + ", amazonComUrl=" + amazonComUrl + ", imageUrl=" + imageUrl
				+ ", wiggleCoUkUrl=" + wiggleCoUkUrl + ", competitiveCyclistComUrl=" + competitiveCyclistComUrl
				+ ", merlinCyclesComUrl=" + merlinCyclesComUrl + ", tredzCoUkUrl=" + tredzCoUkUrl + ", jensonUsaComUrl="
				+ jensonUsaComUrl + "]";
	}



	
	
}
