package com.cts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.cts.model.Product;
import com.cts.repository.ProductRepositoryImpl;
import com.cts.service.ProductServiceImpl;

@SpringBootTest
class ProductCrudOperationsUsingSpringJpaApplicationTests {
	@Mock
	ProductRepositoryImpl repository;
	
	@InjectMocks
	ProductServiceImpl service;
	@Test
	void saveProductTest() {
		Product product=new Product("samsung",23000,"electronics",20);
		Mockito.when(repository.saveProduct(product)).thenReturn("Product Saved Successfully");
		String response=service.saveProduct(product);
		assertEquals("Product saved successfully", response);
	}

}
