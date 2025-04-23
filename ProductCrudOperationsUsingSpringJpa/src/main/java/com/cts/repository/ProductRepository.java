package com.cts.repository;

import java.util.List;

import com.cts.model.Product;

public interface ProductRepository {
	public abstract String saveProduct(Product product);

	public abstract String updateProduct(Product product);

	public abstract String removeProduct(int productId);

	public abstract Product getProduct(int productId);

	public abstract List<Product> getAllProduct();

	public abstract List<Product> getAllProductBetween(int initialPrice, int finalPrice);
	
	public abstract List<Product> getAllProductLarger(int givenPrice);

	public abstract List<Product> getAllProductByCategory(String category);
	// public abstract String saveProduct(Product product);
}
