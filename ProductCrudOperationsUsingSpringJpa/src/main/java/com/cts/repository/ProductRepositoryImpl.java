package com.cts.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.cts.model.Product;
import com.cts.service.ProductServiceImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional //to commit and begin the transaction
public class ProductRepositoryImpl implements ProductRepository {
		//EntityManager-->persist()-->insert, merge()-->update, remove()--delete, find()-->select
	@PersistenceContext
	EntityManager entityManager;
	Logger log=LoggerFactory.getLogger(ProductServiceImpl.class);
	public ProductRepositoryImpl() {
		
	}
	
	@Override
	public String saveProduct(Product product) {
		
		entityManager.persist(product);
		log.info("Product saved");
		return "Product saved successfully";
	}

	@Override
	public String updateProduct(Product product) {
		
		entityManager.merge(product);
		
		return "Product updated successfully";
	}

	@Override
	public String removeProduct(int productId) {
		
		entityManager.remove(getProduct(productId));
		
		return "Product removed successfully";
	}

	@Override
	public Product getProduct(int productId) {
		return entityManager.find(Product.class,productId);
	}

	@Override
	public List<Product> getAllProduct() {
		TypedQuery<Product> result=entityManager.createQuery("select p from Product p",Product.class);
		return result.getResultList();
	}

	@Override
	public List<Product> getAllProductBetween(int initialPrice, int finalPrice) {
		TypedQuery<Product> result=entityManager.createQuery("select p from Product p where p.productPrice between ?1 and ?2",Product.class);
		result.setParameter(1,initialPrice);
		result.setParameter(2,finalPrice);
		return result.getResultList();
	}
	@Override
	public List<Product> getAllProductLarger(int givenPrice) {
		TypedQuery<Product> result=entityManager.createQuery("select p from Product p where p.productPrice > ?1",Product.class);
		result.setParameter(1,givenPrice);
		//result.setParameter(2,finalPrice);
		return result.getResultList();
	}

	@Override
	public List<Product> getAllProductByCategory(String category) {
		TypedQuery<Product> result=entityManager.createQuery("select p from Product p where p.productCategory = ?1",Product.class);
		result.setParameter(1,category);
		return result.getResultList();
	}

}
