package com.cts.model;

import jakarta.persistence.Column; 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="products_info")
@Getter
@Setter
public class Product {
	@Id
	@Column(name="pid")
	@GeneratedValue
	private int productId;
	private String productName;
	@Column(name="price")
	private int productPrice;
	private String productCategory;
	@Column(name="quantity")
	private int productQuantity;
	
	



	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + ", productQuantity=" + productQuantity + "]";
	}





	public Product(String productName, int productPrice, String productCategory, int productQuantity) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productQuantity = productQuantity;
	}
	
	
	
}
