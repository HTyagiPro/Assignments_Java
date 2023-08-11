package com.har.rest.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	
	@Id
	@Column(name = "prod_id")
	private int productId;
	@Column(name = "prod_name")
	private String productName;
	@Column(name = "category")
	private String productCategory;
	@Column(name = "cost")
	private double productCost;
	
	public Product() {
	}

	public Product(int productId, String productName, String productCategory, double productCost) {
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productCost = productCost;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public double getProductCost() {
		return productCost;
	}

	public void setProductCost(double productCost) {
		this.productCost = productCost;
	}

	@Override
	public String toString() {
		return "Product:- \n---------------------------------\nProduct Id: " + productId + "Product Name: " + productName + "\nProduct Category: "
				+ productCategory + "\nProduct Cost: " + productCost + "\n---------------------------------\n";
	}
	
	
	
	
	
}
