package com.cts.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.model.Product;
import com.cts.repository.ProductRepository;
import com.cts.repository.ProductRepositoryImpl;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	Logger log=LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	ProductRepository repository;
	public ProductServiceImpl() {
		repository=new ProductRepositoryImpl();
	}

	@Override
	public String saveProduct(Product product) {
		log.info("In ProductServiceImpl saveproduct method");
		return repository.saveProduct(product);
	}

	@Override
	public String updateProduct(Product product) {
	return repository.updateProduct(product);
	}

	@Override
	public String removeProduct(int productId) {

		return repository.removeProduct(productId);
	}

	@Override
	public Product getProduct(int productId) {
		return repository.getProduct(productId);
	}

	@Override
	public List<Product> getAllProduct() {
		return repository.getAllProduct();
	}

	@Override
	public List<Product> getAllProductBetween(int initialPrice, int finalPrice) {
		return repository.getAllProductBetween(initialPrice, finalPrice);
	}
	@Override
	public List<Product> getAllProductLarger(int givenPrice) {
		return repository.getAllProductLarger(givenPrice);
	}

	@Override
	public List<Product> getAllProductByCategory(String category) {
		// TODO Auto-generated method stub
		return repository.getAllProductByCategory(category);
	}

}
